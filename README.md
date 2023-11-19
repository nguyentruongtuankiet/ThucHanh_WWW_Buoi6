# ThucHanh_WWW_Buoi6
-Sinh viên: **Nguyễn Trường Tuấn Kiệt**
---
# Trang Blog
---
## Back end
---
- **Yêu cầu:** Lập trang web API CRUD
- Ánh xạ `entity`, `repository` extend `JpaRepository`
- Sử dụng 'Spring Boot - REST API'
- **Diagram**
- 
![image](https://github.com/nguyentruongtuankiet/ThucHanh_WWW_Buoi6/assets/104067295/ef0a0006-ddf2-46d2-8eda-5761988728bc)

---
## Font end
---
## Login
- Nếu đăng nhập thành công sẽ vào giao diện trang chủ Blog.
- Còn thất bại form sẽ thông báo không có tài khoản tồn tại.
![image](https://github.com/nguyentruongtuankiet/ThucHanh_WWW_Buoi6/blob/buoi6/MinhChung/login.png?raw=true)
## Blog
- Nếu đăng nhập thành công sẽ vào giao diện trang chủ `Blog`.
- Trang này chứa danh sách các bài `Post` 1 nút `Add Post` để thêm mới 1 bài `Post`.
- Và 1 nút `Log out` để thoát ra giao diện `login`.
- Mỗi bài `Post` đều có thể ấn vào để xem chi tiết được.
![image](https://github.com/nguyentruongtuankiet/ThucHanh_WWW_Buoi6/blob/buoi6/MinhChung/homeblog.png?raw=true)
## Post
- 1 Bài `Post` gồm thông tin bài `Post` và các `Post Comment` của các `User` đọc bài đó.
- Bạn có thể xóa `Post comment` của mình nếu bạn là người đăng.
- và bạn cũng có thể `Post Comment` của mình vào bài `Post` khi ấn Submit
 ![image](https://github.com/nguyentruongtuankiet/ThucHanh_WWW_Buoi6/blob/buoi6/MinhChung/addcmt.png?raw=true)
- Add thành công
 ![image](https://github.com/nguyentruongtuankiet/ThucHanh_WWW_Buoi6/blob/buoi6/MinhChung/addok.png?raw=true)
## Add Post
-- Bạn có thể thêm 1 bài `Post` của bản thân mình
 ![image](https://github.com/nguyentruongtuankiet/ThucHanh_WWW_Buoi6/blob/buoi6/MinhChung/addpost.png?raw=true)
 ## Log out
 -- Để thoát ra giao diện đăng nhập
