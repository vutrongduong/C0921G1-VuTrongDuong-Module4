<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>$Title$</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container-fluid">
    <center>
        <h1>TỜ KHAI Y TẾ</h1>
        <h5>ĐÂY LÀ TÀI LIÊU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT ĐỂ PHÒNG CHỐNG
            DỊCH BỆNH TRUYỀN NHIỄM</h5>
        <p style="color: red">Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể xử lý hình
            sự</p>
        <h4><strong style="color: green">${mess}</strong></h4>
        <strong style="color: yellowgreen">${mess2}</strong>
    </center>
    <th:form modelAttribute="toKhaiYTe" action="/" method="post">
        <label>Họ tên (ghi chữ IN HOA)<span style="color:red">(*)</span></label><br>
        <div><th:input path="ten" cssClass="row border border-secondary border border-2 rounded-3 w-100 p-1 m-1"/></div>
        <div class="row">
            <div class="col-lg-4">
                <label>Năm sinh<span style="color:red">(*)</span></label><br>
                <div><th:select cssClass="border border-secondary border border-2 rounded-3 w-100 p-1 m-1"
                                path="namSinh"
                                items="${namSinhList}"/></div>
            </div>
            <div class="col-lg-4">
                <label>Giới tính<span style="color:red">(*)</span></label><br>
                <div><th:select cssClass="border border-secondary border border-2 rounded-3 w-100 p-1 m-1"
                                path="gioiTinh"
                                items="${gioiTinhList}"/></div>
            </div>
            <div class="col-lg-4">
                <label>Quốc tịch<span style="color:red">(*)</span></label><br>
                <div><th:select cssClass="border border-secondary border border-2 rounded-3 w-100 p-1 m-1"
                                path="quocTich"
                                items="${quocTichList}"/></div>
            </div>
        </div>
        <label>Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác<span style="color:red">(*)</span></label><br>
        <div><th:input path="cmnd"
                       cssClass="row border border-secondary border border-2 rounded-3 w-100 p-1 m-1"/></div>
        <label>Thông tin đi lại<span style="color:red">(*)</span></label>
        <div class="p-2"><th:radiobuttons cssStyle="margin-right: 70px"
                path="thongTinDiLai.phuongTien" items="${phuongTienList}"/></div>

        <div class="row">
            <div class="col-lg-6">
                <label>Số hiệu phương tiện<span style="color:red">(*)</span></label>
                <div><th:input path="thongTinDiLai.soHieu"
                               cssClass="row border border-secondary border border-2 rounded-3 w-100 p-1 m-1"/></div>
            </div>
            <div class="col-lg-6">
                <label>Số ghế<span style="color:red">(*)</span></label>
                <div><th:input path="thongTinDiLai.soGhe"
                               cssClass="row border border-secondary border border-2 rounded-3 w-100 p-1 m-1"/></div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-6">
                <label>Ngày khởi hành<span style="color:red">(*)</span></label>
                <input class="row border border-secondary border border-2 rounded-3 w-100 p-1 m-1" type="date"
                <th:input path="thongTinDiLai.ngayKhoiHanh"/>
            </div>
            <div class="col-lg-6">
                <label>Ngày kết thúc<span style="color:red">(*)</span></label>
                <input class="row border border-secondary border border-2 rounded-3 w-100 p-1 m-1" type="date"
                <th:input path="thongTinDiLai.ngayKetThuc"/>
            </div>
        </div>
        <label>Trong vòng 14 ngày qua , Anh/Chị có đến tỉnh/thành phố nào?<span style="color:red">(*)</span></label>
        <th:textarea cssClass="row border border-secondary border border-2 rounded-3 w-100 p-1 m-1"
                     path="thongTinDiLai.diaDiem"/>
        <h5>Địa chỉ liên lạc</h5>
        <div class="row">
            <div class="col-lg-4">
                <label>Tỉnh / Thành phố<span style="color:red">(*)</span></label>
                <div><th:select cssClass="border border-secondary border border-2 rounded-3 w-100 p-1 m-1"
                                path="lienLac.thanhPho"
                                items="${thanhPhoList}"/></div>
            </div>
            <div class="col-lg-4">
                <label>Quận / Huyện<span style="color:red">(*)</span></label>
                <div><th:select cssClass="border border-secondary border border-2 rounded-3 w-100 p-1 m-1 "
                                path="lienLac.huyen"
                                items="${huyenList}"/></div>
            </div>
            <div class="col-lg-4">
                <label>Phường / Xã<span style="color:red">(*)</span></label>
                <div><th:select cssClass="border border-secondary border border-2 rounded-3 w-100 p-1 m-1"
                                path="lienLac.xa"
                                items="${xaList}"/></div>
            </div>
        </div>
        <label>Địa chỉ nơi ở<span style="color:red">(*)</span></label>
        <th:input cssClass="row border border-secondary border border-2 rounded-3 w-100 p-1 m-1" path="lienLac.diaChi"/>
        <div class="row">
            <div class="col-lg-6">
                <label>Điện thoại<span style="color:red">(*)</span></label>
                <div><th:input path="lienLac.dienThoai"
                               cssClass="row border border-secondary border border-2 rounded-3 w-100 p-1 m-1"/></div>
            </div>
            <div class="col-lg-6">
                <label>Email<span style="color:red">(*)</span></label>
                <div><th:input path="lienLac.email"
                               cssClass="row border border-secondary border border-2 rounded-3 w-100 p-1 m-1"/></div>
            </div>
        </div>
        <h5>Trong vòng 14 ngày qua ,Anh/Chị có thấy xuất hiện dấu hiệu nào sau đây không?<span
                style="color:red">(*)</span>
        </h5>
        <div class="row">
            <div class="col-lg-6">
                <table class="table table-bordered">
                    <tr class="bg-secondary">
                        <td><b>Triệu chứng</b></td>
                        <td><b>Có</b></td>
                    </tr>
                    <tr>
                        <td>Sốt<span style="color: red">(*)</span></td>
                        <td><th:checkbox path="trieuChung" value="Sốt"/></td>
                    </tr>
                    <tr>
                        <td>Ho<span style="color: red">(*)</span></td>
                        <td><th:checkbox path="trieuChung" value="Ho"/></td>
                    </tr>
                    <tr>
                        <td>Khó thở<span style="color: red">(*)</span></td>
                        <td><th:checkbox path="trieuChung" value="Khó thở"/></td>
                    </tr>
                    <tr>
                        <td>Đau họng<span style="color: red">(*)</span></td>
                        <td><th:checkbox path="trieuChung" value="Đau họng"/></td>
                    </tr>
                </table>
            </div>
            <div class="col-lg-6">
                <table class="table table-bordered col-lg-6">
                    <tr class="bg-secondary">
                        <td><b>Triệu chứng</b></td>
                        <td><b>Có</b></td>
                    </tr>
                    <tr>
                        <td>Nôn/buồn nôn<span style="color: red">(*)</span></td>
                        <td><th:checkbox path="trieuChung" value="Nôn/buồn nôn"/></td>
                    </tr>
                    <tr>
                        <td>Tiêu chảy<span style="color: red">(*)</span></td>
                        <td><th:checkbox path="trieuChung" value="Tiêu chảy"/></td>
                    </tr>
                    <tr>
                        <td>Xuất huyết ngoài da<span style="color: red">(*)</span></td>
                        <td><th:checkbox path="trieuChung" value="Xuất huyết ngoài da"/></td>
                    </tr>
                    <tr>
                        <td>Nổi ban ngoài da<span style="color: red">(*)</span></td>
                        <td><th:checkbox path="trieuChung" value="Nổi ban ngoài da"/></td>
                    </tr>
                </table>
            </div>
        </div>
        <%--        <th:checkboxes path="trieuChung" items="${trieuChungList}"/>--%>
        <h5>Lịch sử phơi nhiễm: Trong vòng 14 ngày qua, Anh/Chị có<span style="color:red">(*)</span></h5>
        <div class="row">
            <table class="table table-bordered">
                <tr class="bg-secondary">
                    <td></td>
                    <td>Có</td>
                </tr>
                <tr>
                    <td>Đến trang trại chăn nuôi / chợ buôn bán động vật sống / cơ sở giết mổ động vật /
                        tiếp xúc động vật<span style="color: red">(*)</span>
                    </td>
                    <td><th:checkbox path="phoiNhiem"
                                     value="Đến nơi bị nhiễm"/></td>
                </tr>
                <tr>
                    <td>Tiếp xúc gần(<2m) với người mắc bệnh viêm đường hô hấp do nCoV<span
                            style="color: red">(*)</span>
                    </td>
                    <td><th:checkbox path="phoiNhiem"
                                     value="Tiếp xúc gần"/></td>
                </tr>
            </table>
        </div>
        <label style="color: red">Dữ liệu bạn cung cấp hoàn toàn bảo mật và chỉ phục vụ cho việc phòng chống dịch ,
            thuộc quản lý của Ban chỉ đạo quốc về Phòng chống dịch Covid-19.<br> Khi bạn nhấn nút "Gửi" là bạn đã hiểu
            và đồng ý</label>
        <center>
            <button class="btn btn-success rounded-pill" type="submit">Gửi tờ khai</button>
        </center>
    </th:form>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
        integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
        integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
        crossorigin="anonymous"></script>
</html>
