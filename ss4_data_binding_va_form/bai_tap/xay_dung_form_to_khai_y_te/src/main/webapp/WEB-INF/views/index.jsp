<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<center>
    <h1>TỜ KHAI Y TẾ</h1>
    <h5>ĐÂY LÀ TÀI LIÊU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT ĐỂ PHÒNG CHỐNG
        DỊCH BỆNH TRUYỀN NHIỄM</h5>
    <p style="color: red">Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể xử lý hình sự</p>
</center>
<th:form modelAttribute="toKhaiYTe" action="/" method="post">
    <label>Họ tên (ghi chữ IN HOA)<span style="color:red">(*)</span></label>
    <th:input path="ten"/>
    <div>
        <div>
            <label>Năm sinh<span style="color:red">(*)</span></label>
            <th:select path="namSinh" itemValue="${namSinhList}"/>
        </div>
        <div>
            <label>Giới tính<span style="color:red">(*)</span></label>
            <th:select path="gioiTinh" itemValue="${gioiTinhList}"/>
        </div>
        <div>
            <label>Quốc tịch<span style="color:red">(*)</span></label>
            <th:select path="quocTich" items="${quocTichList}"/>
        </div>
    </div>
    <label>Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác<span style="color:red">(*)</span></label>
    <th:input path="cmnd"/>
    <label>Thông tin đi lại<span style="color:red">(*)</span></label>
    <th:radiobuttons path="thongTinDiLai.phuongTien" items="${phuongTienList}"/>
    <div>
        <div>
            <label>Số hiệu phương tiện<span style="color:red">(*)</span></label>
            <th:input path="thongTinDiLai.soHieu" />
        </div>
        <div>
            <label>Số ghế<span style="color:red">(*)</span></label>
            <th:input path="thongTinDiLai.soGhe" />
        </div>
    </div>
    <div>
        <div>
            <label>Ngày khởi hành<span style="color:red">(*)</span></label>
            <input type="date"
                <th:input path="thongTinDiLai.ngayKhoiHanh"/> >
        </div>
        <div>
            <label>Ngày kết thúc<span style="color:red">(*)</span></label>
            <input type="date"
                <th:input path="thongTinDiLai.ngayKetThuc"/> >
        </div>
    </div>
    <label>Trong vòng 14 ngày qua , Anh/Chị có đến tỉnh/thành phố nào?<span style="color:red">(*)</span></label>
    <th:textarea path="thongTinDiLai.diaDiem"/>
    <h5>Địa chỉ liên lạc</h5>
    <div>
        <div>
            <label>Tỉnh / Thành phố<span style="color:red">(*)</span></label>
            <th:select path="lienLac.thanhPho" items="${thanhPhoList}"/>
        </div>
        <div>
            <label>Quận / Huyện<span style="color:red">(*)</span></label>
            <th:select path="lienLac.huyen" itemValue="${huyenList}"/>
        </div>
        <div>
            <label>Phường / Xã<span style="color:red">(*)</span></label>
            <th:select path="lienLac.xa" items="${xaList}"/>
        </div>
    </div>
    <label>Địa chỉ nơi ở<span style="color:red">(*)</span></label>
    <th:input path="lienLac.diaChi"/>
    <div>
        <div>
            <label>Điện thoại<span style="color:red">(*)</span></label>
            <th:input path="lienLac.dienThoai" />
        </div>
        <div>
            <label>Email<span style="color:red">(*)</span></label>
            <th:input path="lienLac.email"/>
        </div>
    </div>
    <h5>Trong vòng 14 ngày qua ,Anh/Chị có thấy xuất hiện dấu hiệu nào sau đây không?<span style="color:red">(*)</span></h5>
    <th:checkboxes path="trieuChung" items="${trieuChungList}"/>
    <h5>Lịch sử phơi nhiễm: Trong vòng 14 ngày qua, Anh/Chị có<span style="color:red">(*)</span></h5>
    <th:input path="phoiNhiem" />
</th:form>
</body>
</html>
