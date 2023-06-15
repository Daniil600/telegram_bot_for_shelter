package skypro.teamwork.telegram_bot_for_shelter.model;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "binary_content")
public class BinaryContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private byte[] fileAsArrayOfBytes;

    public BinaryContent() {
    }


    public static BinaryContentBuilder builder() {
        return new BinaryContentBuilder();
    }

    public Long getId() {
        return id;
    }

    public byte[] getFileAsArrayOfBytes() {
        return fileAsArrayOfBytes;
    }

    public void setFileAsArrayOfBytes(byte[] fileAsArrayOfBytes) {
        this.fileAsArrayOfBytes = fileAsArrayOfBytes;
    }

    public static class BinaryContentBuilder {
        private BinaryContent binaryContent;

        public BinaryContentBuilder() {
            binaryContent = new BinaryContent();
        }

        public BinaryContentBuilder fileAsArrayOfBytes(byte[] fileAsArrayOfBytes) {
            binaryContent.setFileAsArrayOfBytes(fileAsArrayOfBytes);
            return this;
        }

        public BinaryContent build() {
            return binaryContent;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BinaryContent that = (BinaryContent) o;
        return Objects.equals(id, that.id) && Arrays.equals(fileAsArrayOfBytes, that.fileAsArrayOfBytes);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id);
        result = 31 * result + Arrays.hashCode(fileAsArrayOfBytes);
        return result;
    }

    @Override
    public String toString() {
        return "BinaryContent{" +
                "id=" + id +
                ", fileAsArrayOfBytes=" + Arrays.toString(fileAsArrayOfBytes) +
                '}';
    }
}