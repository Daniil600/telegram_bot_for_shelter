package skypro.teamwork.telegram_bot_for_shelter.model.cat;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "photo_cats")
public class PhotoCats {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "photoCats_seq")
    private long id;
    private String filePath;
    private long fileSize;
    private String mediaType;
    @Lob
    private byte[] data;
    @OneToOne
    @JoinColumn(name = "cat_id")
    private Cat cat;

    public PhotoCats() {

    }

    public PhotoCats(Long id, String filePath, String mediaType, long fileSize, Cat cat) {
        this.id = id;
        this.filePath = filePath;
        this.mediaType = mediaType;
        this.fileSize = fileSize;
        this.cat = cat;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PhotoCats)) return false;
        PhotoCats photoCats = (PhotoCats) o;
        return id == photoCats.id && fileSize == photoCats.fileSize && Objects.equals(filePath, photoCats.filePath) && Objects.equals(mediaType, photoCats.mediaType) && Arrays.equals(data, photoCats.data) && Objects.equals(cat, photoCats.cat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, filePath, fileSize, mediaType, cat);
    }

    @Override
    public String toString() {
        return "PhotoCats{" +
                "id=" + id +
                ", filePath='" + filePath + '\'' +
                ", fileSize=" + fileSize +
                ", mediaType='" + mediaType + '\'' +
                ", data=" + Arrays.toString(data) +
                ", cat=" + cat +
                '}';
    }
}
