package com.DungDV13.ApiCinemaFpt.controller.frontend;

import com.DungDV13.ApiCinemaFpt.model.Movice;
import com.DungDV13.ApiCinemaFpt.service.MoviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
//import javax.validation.Valid;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;


@Controller
@CrossOrigin
@RequestMapping("api/movice/")
public class MoviceController {
    @Autowired
    MoviceService moviceService;

//    @PostConstruct
//    public void initData(){
//
//      Movice movice = new Movice("Cùng với cái chết của Iron Man, sự ra đi của Black Widow Natasha Romanoff là mất mát không thể thay thế của team Avengers. Người phụ nữ vừa mạnh mẽ vừa dịu dàng, coi Biệt Đội Siêu Anh Hùng như “gia đình” đã ra đi mãi mãi để đổi lấy viên đá linh hồn. Sự hy sinh của cô để lại trong lòng các fan vũ trụ điện ảnh Marvel niềm đau khó tả. May mắn thay, Marvel thấu hiểu tình yêu người hâm mộ dành cho Góa Phụ Đen.  <br /> Dù khó thể trở lại trong tương lai MCU, Natasha và fan được “tặng” một bộ phim riêng mặc sức tung hoành. Cuộc hành trình độc lập của nữ chiến binh xuất sắc nhất Avengers sẽ đưa cô đụng độ một trong những kẻ thù “sừng sỏ” nhất – chuyên gia copy Taskmaster. Chuyến phiêu lưu sẽ đưa lên màn ảnh rộng quá khứ của Black Widow trước khi gia nhập S.H.I.E.L.D. Natasha sẽ gặp lại “gia đình” cũ gồm các đặc vụ  Yelena Belova (Florence Pugh), Melina Vostokoff (Rachel Weisz), Alexei Shostakov hay còn gọi là Red Guardian (David Harbour). Đặc biệt, theo nhiều tin đồn, “Iron Man” Tony Stark dù đã tạm biệt MCU vẫn xuất hiện trong phim. Black Widow dự kiến khởi chiếu vào 30.04.2020. Tuy nhiên, do đại dịch Covid-19 đột ngột ập đến, bom tấn buộc phải dời lịch chiếu hơn nửa năm trời. Điều này ảnh hưởng nghiêm trọng đến timeline dự tính của MCU, khiến tất cả các bộ phim khác cùng vũ trụ phải trì hoãn theo. Sau một năm thành công với hai đề cử Oscar Nữ chính xuất sắc nhất (Marriage Story) và Nữ phụ xuất sắc nhất (Jojo Rabbit), Black Widow chắc chắn sẽ tiếp tục đưa danh tiếng quả bom gợi cảm của Hollywood – Scarlett Johansson lan rộng toàn cầu. Phim mới Black Widow: Góa Phụ Đen, ra mắt tại các rạp chiếu phim từ 11.2020.",
//              "https://static.lag.vn/upload/news/20/03/25/bw-2020-cuong-phim-758x401_ZCZB.jpg?w=800&encoder=wic&subsampling=444",
//              2020, "BLACK WIDOW", "Mỹ", 5, "160",
//              "Người phụ nữ vừa mạnh mẽ vừa dịu dàng, coi Biệt Đội Siêu Anh Hùng như “gia đình” đã ra đi mãi mãi để đổi lấy viên đá linh hồn. Sự hy sinh của cô để lại trong lòng các fan vũ trụ điện ảnh Marvel niềm đau khó tả.",
//              "https://www.youtube.com/watch?v=ybji16u608U");
//      moviceService.save(movice);
//
//        Movice movice1 = new Movice("Apocalypse là dị nhân đầu tiên và hùng mạnh nhất của vũ trụ X-Men, đã tích lũy được rất nhiều quyền năng đột biến khác nhau, trở thành kẻ bất tử và bất khả chiến bại. Sau khi tỉnh dậy từ giấc ngủ hàng ngàn năm, hắn cảm thấy thất vọng với thế giới này và năng lực đáng sợ nhất của hắn là khống chế những người khác và biến họ thành kỵ sĩ của mình, nhằm tẩy sạch nhân loại và tạo ra một trật tự thế giới mới và qua đó, hắn sẽ trị vì nó. Số phận của Trái Đất phải đối mặt với tình huống ngàn cân treo sợi tóc, Raven cùng với sự giúp đỡ của Giáo Sư X buộc phải dẫn dắt một đội X-Men trẻ tuổi nhằm chống lại kẻ thù lớn nhất từ trước đến nay và cứu rỗi nhân loại khỏi sự diệt chủng. Câu chuyện trong X-Men: Apocalypse diễn ra 10 năm sau các sự kiện trong X-Men: Days of Future Past, thiết lập lại toàn bộ thời gian của bộ truyện. Lúc này Magneto đang trốn ở Ba Lan, sống một cuộc sống bình thường với người phụ nữ ông yêu. Nhưng sự mất mát của cô ấy đẩy ông vào thế giới của sự tuyệt vọng và bóng tối. Ông ta tìm đến Apocalypse như một vị cứu tinh, một vị thần và cảm thấy mãn nguyện khi được ở bên ông ta cùng 3 thành viên khác trong nhóm Tứ kỵ gồm Storm, Psylocke và Archangel.",
//                "https://i.ytimg.com/vi/NszeFgkfM3o/maxresdefault.jpg",
//                2016, "Dị Nhân 7", "Mỹ", 5, "130",
//                "Apocalypse là dị nhân đầu tiên và hùng mạnh nhất của vũ trụ X-Men, đã tích lũy được rất nhiều quyền năng đột biến khác nhau, trở thành kẻ bất tử và bất khả chiến bại",
//                "youtube.com/watch?v=Xyoonc4pxgE&feature=emb_title");
//        moviceService.save(movice1);
//
//        Movice movice2 = new Movice("Marvel một lần nữa đưa đến cho khán giả câu chuyện mới đầy hấp dẫn về chàng Người Sói Logan - siêu anh hùng vốn được đông đảo khán giả yêu mến. Được đặt sau mốc sự kiện của X-Men: The Last Stand, bộ phim dõi theo hành trình của Logan lưu lạc tới đất nước Nhật Bản xa xôi, nơi anh bị lạc lõng hoàn toàn. Gặp lại một cố nhân tại xứ mặt trời mọc, Logan nhận được một đề nghị có thể khiến anh thay đổi hoàn toàn cuộc sống cô độc: loại bỏ tất cả các năng lực để anh trở thành người thường. Giữa muôn trùng nguy hiểm đến từ những kẻ thù xung quanh, liệu anh chàng Người Sói có từ bỏ sự bất tử của mình?",
//                "https://znews-photo.zadn.vn/w660/Uploaded/spuocaw/2017_02_23/maxresdefault.jpg",
//                2013 ,"Người sói wolverine", "Mỹ, Úc", 4, "126",
//                "Marvel một lần nữa đưa đến cho khán giả câu chuyện mới đầy hấp dẫn về chàng Người Sói Logan - siêu anh hùng vốn được đông đảo khán giả yêu mến.",
//                "https://www.youtube.com/watch?v=H0_bxx9dO5Y");
//        moviceService.save(movice2);
//    }

    @GetMapping("/getAll")
    public ResponseEntity<Object> getAll(@RequestParam(defaultValue = "0", required=false) int page, @RequestParam(defaultValue = "5", required=false) int size) {
        Pageable pageable = PageRequest.of(page, size);
        return new ResponseEntity<>(moviceService.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/getRandomChoBanner")
    public ResponseEntity<Object> getRandomChoBanner() {
        List<Movice> listMovice = moviceService.findAll();

        Random rd = new Random();
        int x = rd.nextInt(listMovice.size()-1);
        System.out.println("ramdom: "+ listMovice.get(x).getId());
        return new ResponseEntity<>(moviceService.findById(listMovice.get(x).getId()) , HttpStatus.OK);
    }

    @GetMapping("/findSuatChieuSom")
    public ResponseEntity<Page<Movice>> findSuatChieuSom(@RequestParam(defaultValue = "0", required=false) int page, @RequestParam(defaultValue = "3", required=false) int size) {
        Pageable pageable = PageRequest.of(page, size);
        return new ResponseEntity<Page<Movice>>(moviceService.findSuatChieuSom(pageable), HttpStatus.OK);
    }

    @GetMapping("/findSuatChieuBinhThuong")
    public ResponseEntity<Page<Movice>> findSuatChieuBinhThuong(@RequestParam(defaultValue = "0", required=false) int page, @RequestParam(defaultValue = "3", required=false) int size) {
        Pageable pageable = PageRequest.of(page, size);
        return new ResponseEntity<Page<Movice>>(moviceService.findSuatChieuBinhThuong(pageable), HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Object> getById(@PathVariable long id) {
        return new ResponseEntity<>(moviceService.findById(id), HttpStatus.OK);
    }


    @PostMapping("/insert")
    public ResponseEntity<Object> insert(@Validated @RequestBody Movice movice) {
        moviceService.save(movice);
        return ResponseEntity.ok().body("OK! insert successfully!");
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Object> update(@PathVariable long id, @Validated @RequestBody Movice movice) {
        movice.setId(id);
        moviceService.save(movice);
        return ResponseEntity.ok().body("OK! update successfully!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable long id) {
        moviceService.deleteById(id);
        return ResponseEntity.ok().body("OK! delete successfully!");
    }
}
