package skypro.teamwork.telegram_bot_for_shelter.service.cats;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import skypro.teamwork.telegram_bot_for_shelter.model.cat.Cat;
import skypro.teamwork.telegram_bot_for_shelter.model.cat.PhotoCats;
import skypro.teamwork.telegram_bot_for_shelter.repository.PhotoCatsRepository;

import javax.imageio.ImageIO;
import javax.transaction.Transactional;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;

import static java.nio.file.StandardOpenOption.CREATE_NEW;

@Service
@Transactional
public class PhotoCatsService {
    @Value("${path.to.photocats.folder}")
    private String photoCatsDir;

    private final CatService catService;
    private final PhotoCatsRepository photoCatsRepository;

    public PhotoCatsService(PhotoCatsRepository photoCatsRepository, CatService catService) {
        this.photoCatsRepository = photoCatsRepository;
        this.catService = catService;
    }

    public PhotoCats findPhotoByCat(long cat_id) {
        return photoCatsRepository.findPhotoCatsById(cat_id).getPhotoCats();
    }

    public void uploadPhotoCats(Long catId, MultipartFile file) throws IOException {
        Cat cat = catService.findCat(catId);

        Path filePath = Path.of(photoCatsDir, catId + "." + getExtension(file.getOriginalFilename()));
        Files.createDirectories(filePath.getParent());
        Files.deleteIfExists(filePath);

        try (InputStream is = file.getInputStream();
             OutputStream os = Files.newOutputStream(filePath, CREATE_NEW);
             BufferedInputStream bis = new BufferedInputStream(is, 1024);
             BufferedOutputStream bos = new BufferedOutputStream(os, 1024);
        ) {
            bis.transferTo(bos);
        }

        PhotoCats photoCats = findPhotoByCat(catId);
        photoCats.setCat(cat);
        photoCats.setFilePath(filePath.toString());
        photoCats.setFileSize(file.getSize());
        photoCats.setMediaType(file.getContentType());
        photoCats.setData(file.getBytes());

        photoCatsRepository.save(photoCats);
    }

    public String getExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }

    public byte[] generateImagePreview(Path filePath) throws IOException {
        try (InputStream is = Files.newInputStream(filePath);
             BufferedInputStream bis = new BufferedInputStream(is, 1024);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            BufferedImage image = ImageIO.read(bis);

            int height = image.getHeight() / (image.getWidth() / 100);
            BufferedImage preview = new BufferedImage(100, height, image.getType());
            Graphics2D graphics = preview.createGraphics();
            graphics.drawImage(image, 0, 0, 100, height, null);
            graphics.dispose();

            ImageIO.write(preview, getExtension(filePath.getFileName().toString()), baos);
            return baos.toByteArray();
        }
    }

    public Collection<PhotoCats> getAllPhotoCats(Integer pageNumber, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber - 1, pageSize);
        return photoCatsRepository.findAll(pageRequest).getContent();
    }
}
