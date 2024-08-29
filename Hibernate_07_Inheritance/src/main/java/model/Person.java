package model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
/*
InheritanceType.SINGLE_TABLE: Tất cả các lớp con được lưu trong một bảng duy nhất, Hiệu suất truy vấn cao, đơn giản, Cột dư thừa cho các lớp con không liên quan.
InheritanceType.TABLE_PER_CLASS: Mỗi lớp con được lưu trong một bảng riêng biệt, Dữ liệu không bị dư thừa, Truy vấn phức tạp và có thể chậm hơn.
InheritanceType.JOINED: Mỗi lớp con được lưu trong bảng riêng và có bảng chính cho lớp cha. Các bảng được liên kết với nhau thông qua khóa ngoại, Thiết kế dữ liệu chuẩn hóa, tránh dư thừa, Truy vấn yêu cầu nhiều phép nối (JOIN), có thể ảnh hưởng đến hiệu suất.
*/
public class Person {
    @Id
    private String id;
    @Column(columnDefinition = "NVARCHAR(50)")
    private String name;
    private Date dob;

    public Person() {
    }

    public Person(String id, String name, Date dob) {
        this.id = id;
        this.name = name;
        this.dob = dob;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}
