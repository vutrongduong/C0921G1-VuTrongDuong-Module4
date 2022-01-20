package vn.codegym.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SongDto {
    private Long id;
    @NotEmpty(message = "Không được phép để trống")
    @Size(max = 800,message = "Không vượt quá 800 ký tự")
    @Pattern(regexp = "^[a-zA-z0-9]*$",message = "Không chứa các kí tự đặc biệt")
    private String name;
    @NotEmpty(message = "Không được phép để trống")
    @Size(max = 300,message = "Không vượt quá 300 ký tự")
    @Pattern(regexp = "^[a-zA-z0-9]*$",message = "Không chứa các kí tự đặc biệt")
    private String singer;
    @NotEmpty(message = "Không được phép để trống")
    @Size(max = 1000,message = "Không vượt quá 1000 ký tự")
    @Pattern(regexp = "^[a-zA-z0-9,]*$",message = "Ngoại trừ dấu phẩy “,” , các ký tự đặc biệt còn lại không được phép lưu vào DB")
    private String type;

    public SongDto() {
    }

    public SongDto(@NotEmpty(message = "Không được phép để trống") @Size(max = 800, message = "Không vượt quá 800 ký tự") @Pattern(regexp = "^[a-zA-z0-9]*$", message = "Không chứa các kí tự đặc biệt") String name, @NotEmpty(message = "Không được phép để trống") @Size(max = 300, message = "Không vượt quá 300 ký tự") @Pattern(regexp = "^[a-zA-z0-9]*$", message = "Không chứa các kí tự đặc biệt") String singer, @NotEmpty(message = "Không được phép để trống") @Size(max = 1000, message = "Không vượt quá 1000 ký tự") @Pattern(regexp = "^[a-zA-z0-9,]$", message = "Ngoại trừ dấu phẩy “,” , các ký tự đặc biệt còn lại không được phép lưu vào DB") String type) {
        this.name = name;
        this.singer = singer;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
