package skypro.teamwork.telegram_bot_for_shelter.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import skypro.teamwork.telegram_bot_for_shelter.model.PhotoCatsReport;
import skypro.teamwork.telegram_bot_for_shelter.model.ReportCat;
import skypro.teamwork.telegram_bot_for_shelter.repository.PhotoCatsReportRepository;

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
public class PhotoCatsReportService {
    @Value("${path.to.photocatsreport.folder}")
    private String photoCatsReportDir;

    private final ReportCatService reportCatService;
    private final PhotoCatsReportRepository photoCatsReportRepository;

    public PhotoCatsReportService(PhotoCatsReportRepository photoCatsReportRepository, ReportCatService reportCatService) {
        this.photoCatsReportRepository = photoCatsReportRepository;
        this.reportCatService = reportCatService;
    }

    public PhotoCatsReport findPhotoByReportCat(long reportCatId) {
        return photoCatsReportRepository.findPhotoCatsReportById(reportCatId).getPhotoCatsReport();
    }

    public void uploadPhotoCatsReport(Long reportCatId, MultipartFile file) throws IOException {
        ReportCat reportCat = reportCatService.findReportCat(reportCatId);

        Path filePath = Path.of(photoCatsReportDir, reportCatId + "." + getExtension(file.getOriginalFilename()));
        Files.createDirectories(filePath.getParent());
        Files.deleteIfExists(filePath);

        try (InputStream is = file.getInputStream();
             OutputStream os = Files.newOutputStream(filePath, CREATE_NEW);
             BufferedInputStream bis = new BufferedInputStream(is, 1024);
             BufferedOutputStream bos = new BufferedOutputStream(os, 1024);
        ) {
            bis.transferTo(bos);
        }

        PhotoCatsReport photoCatsReport = findPhotoByReportCat(reportCatId);
        photoCatsReport.setReportCat(reportCat);
        photoCatsReport.setFilePath(filePath.toString());
        photoCatsReport.setFileSize(file.getSize());
        photoCatsReport.setMediaType(file.getContentType());
        photoCatsReport.setData(file.getBytes());

        photoCatsReportRepository.save(photoCatsReport);
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

    public Collection<PhotoCatsReport> getAllPhotoCatsReport(Integer pageNumber, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber - 1, pageSize);
        return photoCatsReportRepository.findAll(pageRequest).getContent();
    }
}
