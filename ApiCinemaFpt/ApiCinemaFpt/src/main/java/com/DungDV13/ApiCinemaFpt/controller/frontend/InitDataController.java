package com.DungDV13.ApiCinemaFpt.controller.frontend;

import com.DungDV13.ApiCinemaFpt.model.Movice;
import com.DungDV13.ApiCinemaFpt.model.PhongChieu;
import com.DungDV13.ApiCinemaFpt.model.Role;
import com.DungDV13.ApiCinemaFpt.model.RoleName;
import com.DungDV13.ApiCinemaFpt.repository.PhongChieuRepository;
import com.DungDV13.ApiCinemaFpt.repository.RoleRepository;
import com.DungDV13.ApiCinemaFpt.service.MoviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;

@Controller
public class InitDataController {
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PhongChieuRepository rapChieuRepository;
    @Autowired
    MoviceService moviceService;

//    @PostConstruct
//        public void initData(){
//
//            for(int i=1; i<5; i++){
//                PhongChieu phongChieu = new PhongChieu("rap "+ i) ;
//                rapChieuRepository.save(phongChieu);
//            }
//
//         Role role1 = new Role(RoleName.ROLE_USER);
//         Role role2 = new Role(RoleName.ROLE_CUSTOMER);
//         Role role3 = new Role(RoleName.ROLE_ADMIN);
//         roleRepository.save(role1);
//         roleRepository.save(role2);
//         roleRepository.save(role3);
//
//        Movice movice = new Movice(
//                "Avengers 4: Endgame",
//                "Biệt Đội Siêu Anh Hùng 4: Tàn Cuộc (Avengers 4: Endgame) ra mắt vào tháng 4/2019 sẽ giải quyết triệt để những khúc mắc đã vạch ra suốt 22 bộ phim trước đó của Vụ trụ điện ảnh Marvel (MCU).",
//                "Biệt Đội Siêu Anh Hùng 4: Tàn Cuộc (Avengers 4: Endgame) ra mắt vào tháng 4/2019 sẽ giải quyết triệt để những khúc mắc đã vạch ra suốt 22 bộ phim trước đó của Vụ trụ điện ảnh Marvel (MCU). Hai tháng sau đó, Người Nhện 2 là khởi đầu hoàn toàn mới dành cho MCU.<br/>Sau sự kiện Thanos làm cho một nửa vũ trụ tan biến và khiến cho biệt đội Avengers thảm bại, những siêu anh hùng sống sót phải tham gia trận chiến cuối cùng trong Avengers: Endgame.",
//                5,
//                "https://www.youtube.com/watch?v=JsTxPRKo5Bw&feature=youtu.be",
//                "http://image.phimmoizz.net/post/2019/04/21/popup-avenger-endgame-800kb.jpg",
//                "http://image.phimmoizz.net/film/7166/poster.medium.jpg",
//                "181",
//                "Mỹ",
//                2019
//        );
//        moviceService.save(movice);
//
//        Movice movice2 = new Movice(
//                "Iron Man 3",
//                "Từ sau những sự kiện và những trận chiến đầy ám ảnh trong The Avengers, Tony Stark quay về ở ẩn trong căn biệt thự sang trọng của mình.",
//                "Từ sau những sự kiện và những trận chiến đầy ám ảnh trong The Avengers, Tony Stark quay về ở ẩn trong căn biệt thự sang trọng của mình, tạm thời chờ đợi trong tư cách một tỷ phú giàu có được yêu mến và gác danh phận siêu anh hùng sang một bên.<br/>Tuy nhiên, những hiểm họa mới lại tiếp tục xuất hiện dưới bóng ma bao trùm của một quái nhân, đồng thời cũng là một thiên tài về công nghệ - The Mandarin. Người bạn thân trong lực lượng quân đội Hoa Kỳ của Tony - James Rhodes cần tới sự giúp đỡ của anh và những bộ giáp siêu việt.<br/>Mọi chuyện không hề dễ dàng như Tony và James tưởng tượng: dưới sức mạnh thần bí của mười chiếc nhẫn vũ trụ, The Mandarin đã đánh bại \"Người Sắt\", đồng thời khiến siêu anh hùng - tỷ phú trở thành kẻ mất trí nhớ...",
//                4,
//                "https://www.youtube.com/watch?v=P6uTPVyopXo",
//                "https://images8.alphacoders.com/378/thumb-1920-378546.jpg",
//                "http://image.phimmoizz.net/film/2/poster.medium.jpg",
//                "190",
//                "Mỹ",
//                2013
//        );
//        moviceService.save(movice2);
//
//        Movice movice3 = new Movice(
//                "Thor 3: Ragnarok",
//                "Sau khi Loki Loki soán ngôi cha Odin, vị thần tinh quái này tiếp tục mở đường nhiễu loạn tiến từ cầu Bifrost vào trong Asgard.",
//                "Ragnarok ám chỉ “tận cùng của vũ trụ”, đồng nghĩa với trận chiến sống còn của chín cõi (Nine Realms). Sau khi Loki Loki soán ngôi cha Odin, vị thần tinh quái này tiếp tục mở đường nhiễu loạn tiến từ cầu Bifrost vào trong Asgard.<br/>Ở bên kia vũ trụ, Thor (Chris Hemsworth) phải bước vào một cuộc chiến đầy khốc liệt với đối thủ mà anh sẽ gặp là một đồng đội cũ đến từ biệt đội Avenger – Hulk. Cuộc tìm kiếm sự sống còn của Thor khiến anh phải chạy đua với thời gian để ngăn chặn Hela (Cate Blanchett) tiêu diệt cả thế giới anh đang sống cùng nền văn minh Asgard.",
//                5,
//                "https://youtu.be/0MEmhjJk5e8",
//                "https://images.justwatch.com/backdrop/14507975/s1440/thor-ragnarok",
//                "http://image.phimmoizz.net/film/3243/poster.medium.jpg",
//                "130",
//                "Mỹ",
//                2016
//        );
//        moviceService.save(movice3);
//
//        Movice movice4 = new Movice(
//                "Captain America 3: Civil War",
//                "Captain America: Civil War là câu chuyện theo sau sự kiện Avengers: Age Of Ultron",
//                "Captain America: Civil War là câu chuyện theo sau sự kiện Avengers: Age Of Ultron, các liên minh chính phủ trên toàn thế giới thông qua một hiệp ước được thiết lập để điều chỉnh hoạt động của tất cả siêu anh hùng. Điều này gây ra sự phân cực trong nội bộ nhóm Avengers, tạo nên hai phe gồm Iron Man và Captain America, gây ra một trận chiến sử thi giữa những người đồng đội",
//                5,
//                "https://youtu.be/dKrVegVI0Us",
//                "https://storage.googleapis.com/plugbucket/pub/up/b/b91/b91a6878ec5c4742a45a7f301605593d/img1.jpg",
//                "http://image.phimmoizz.net/film/3086/poster.medium.jpg",
//                "147",
//                "Mỹ,Đức",
//                2016
//        );
//        moviceService.save(movice4);
//
//        Movice movice5 = new Movice(
//                "Captain Marvel ",
//                "Captain Marvel là một cuộc phiêu lưu hoàn toàn mới đến với một thời kỳ chưa từng xuất hiện trong vũ trụ điện ảnh Marvel",
//                "Lấy bối cảnh những năm 90s, Captain Marvel là một cuộc phiêu lưu hoàn toàn mới đến với một thời kỳ chưa từng xuất hiện trong vũ trụ điện ảnh Marvel. Bộ phim kể về con đường trở thành siêu anh hùng mạnh mẽ nhất vũ trụ của Carol Danvers. Bên cạnh đó, trận chiến ảnh hưởng đến toàn vũ trụ giữa tộc Kree và tộc Skrull đã lan đến Trái Đất, liệu Danvers và các đồng minh có thể ngăn chặn binh đoàn Skrull cũng như các thảm họa tương lai?",
//                4,
//                "https://youtu.be/IIIgZI8QDc8",
//                "https://weliveentertainment.com/wp-content/uploads/2019/03/captain-marvel-banner-2.jpg",
//                "http://image.phimmoizz.net/film/7399/poster.medium.jpg",
//                "123",
//                "Mỹ,Úc",
//                2019
//        );
//        moviceService.save(movice5);
//
//        Movice movice6 = new Movice(
//                "SÁT THỦ VÔ CÙNG CỰC",
//                "Xoay quanh Joon, chàng cựu điệp viên của NIS, \"dứt áo ra đi\" khỏi tổ chức, ngày đêm cống hiến với sở thích truyện tranh.",
//                "Xoay quanh Joon, chàng cựu điệp viên của NIS, \"dứt áo ra đi\" khỏi tổ chức, ngày đêm cống hiến với sở thích truyện tranh. Vòng xoáy \"cơm áo gạo tiền\" nào phải dễ, truyện anh sáng tác, chẳng mấy ai quan tâm, cho đến khi, anh tự kể lại trải nghiệm điệp viên của mình, kể chậm rãi, từng từ một, lượt view tăng lên, nhưng kéo theo đó, là bao rắc rối ập đến khi thông tin mật đều được phơi bày.",
//                5,
//                "https://youtu.be/i8X6Snxa65U",
//                "https://i.ytimg.com/vi/9fawuOPEUMc/maxresdefault.jpg",
//                "http://image.phimmoizz.net/film/10358/poster.medium.jpg",
//                "110",
//                "Hàn Quốc",
//                2020
//        );
//        moviceService.save(movice6);
//
//        Movice movice7 = new Movice(
//                "ÔNG BẠN GĂNG-TƠ",
//                "Ông Bạn Găng-Tơ kể về tay giang hồ hay khoe mẽ Young-Ki với ước mơ có một cuộc sống “đỉnh cao” bằng cách thường xuyên chơi vé số trực tuyến.",
//                "Ông Bạn Găng-Tơ kể về tay giang hồ hay khoe mẽ Young-Ki với ước mơ có một cuộc sống “đỉnh cao” bằng cách thường xuyên chơi vé số trực tuyến.Trong một lần quậy phá, gã bị tòa tuyên án 150 giờ lao động công ích. Nhiệm vụ của Young-Ki chính là chăm sóc cho vị Jang-Soo - một vị luật sư nổi tiếng và giàu có nay lại bại liệt toàn thân và sắp chết sau cơn bạo bệnh.",
//                5,
//                "https://youtu.be/fw_37uXxENM",
//                "https://i.ytimg.com/vi/R0E-vhZXSSs/maxresdefault.jpg",
//                "http://image.phimmoizz.net/film/9879/poster.medium.jpg",
//                "117",
//                "Hàn Quốc",
//                2020
//        );
//        moviceService.save(movice7);
//
//        Movice movice8 = new Movice(
//                "SỞ THÚ THOÁT Ế",
//                "Một luật sự tập sự tên Tae-soo (Ahn Jae-hong) được công ty giao nhiệm vụ tiếp quản việc kinh doanh của vườn thú khi gần như tất cả các con thú đã bị bán đi.",
//                "Một luật sự tập sự tên Tae-soo (Ahn Jae-hong) được công ty giao nhiệm vụ tiếp quản việc kinh doanh của vườn thú khi gần như tất cả các con thú đã bị bán đi. Một ý tưởng táo bạo đã được đưa ra để cứu vườn thú “thoát ế”: Các nhân viên phải mặc các bộ đồ thú và diễn như những con thú “thứ thiệt”. Mọi chuyện bất ngờ vượt khỏi tầm kiểm soát khi sở thú đột nhiên trở thành hiện tượng trên mạng xã hội. Các nhân viên phải làm gì nếu mọi chuyện vỡ lở?",
//                5,
//                "https://youtu.be/ie6lVdIWAHk",
//                "https://kenh14cdn.com/thumb_w/600/2020/2/15/artboard-1-copy-11-1581783719880433094222-crop-1581783737112529820620.png",
//                "http://image.phimmoizz.net/film/10353/poster.medium.jpg",
//                "120",
//                "Hàn Quốc",
//                2020
//        );
//        moviceService.save(movice8);
//
//        Movice movice9 = new Movice(
//                "BIỆT ĐỘI BẤT HẢO",
//                "Đội Điều Tra Đặc Biệt do đội trưởng Oh Gu-tak thành lập, với tiêu chí không cần quan tâm phương pháp tốt xấu, chỉ cần “bắt sống bọn tội phạm",
//                "Đội Điều Tra Đặc Biệt do đội trưởng Oh Gu-tak thành lập, với tiêu chí không cần quan tâm phương pháp tốt xấu, chỉ cần “bắt sống bọn tội phạm”. Thành viên gạo cội nhất của đội là tay đấm Park Woong-chul, người đã vào tù cũng là đại ca được tôn kính. Hai thành viên mới được chiêu mộ thêm là mỹ nữ chân dài bốc lửa - thiên tài lừa đảo Kwak No-soon và tay cảnh sát lì lợm đang lĩnh án Ko Yoo-sung.",
//                5,
//                "https://youtu.be/z6ukWvQ-YH8",
//                "https://s3img.vcdn.vn/mobile/123phim/2019/10/biet-doi-bat-hao-bad-guys-reign-of-chaos-15706059053949_540x225.jpg",
//                "http://image.phimmoizz.net/film/9487/poster.medium.jpg",
//                "120",
//                "Hàn Quốc",
//                2020
//        );
//        moviceService.save(movice9);
//
//        Movice movice10 = new Movice(
//                "TRÙM, CỚM VÀ ÁC QUỶ",
//                "Có ai ngờ được rằng Jang Dong Su - một tay trùm khét tiếng cũng có lúc trở thành nạn nhân của một kẻ giết người máu lạnh?!",
//                "Có ai ngờ được rằng Jang Dong Su - một tay trùm khét tiếng cũng có lúc trở thành nạn nhân của một kẻ giết người máu lạnh?! Chính sự kiện này đã mở ra một cuộc hợp tác bất đắc dĩ giữa ông trùm và gã cớm để truy bắt hung thủ. Tất nhiên, mặc dù phối hợp với nhau nhưng hai bên vẫn ngấm ngầm sử dụng những luật lệ và giữa cho mình những bí mật riêng. Liệu cuộc vây bắt này sẽ diễn ra như thế nào? Ai sẽ người dành được chiến thắng cuối cùng?",
//                5,
//                "https://youtu.be/Nn3dGGRkObo",
//                "https://i.ytimg.com/vi/-3HodBXe8_w/maxresdefault.jpg",
//                "http://image.phimmoizz.net/film/8873/poster.medium.jpg",
//                "120",
//                "Hàn Quốc",
//                2020
//        );
//        moviceService.save(movice10);
//
//        Movice movice12 = new Movice(
//                "DẠ QUỶ",
//                "Dạ Quỷ là một câu chuyện về hoàng tử Lee (do Huyn Bin thủ vai) ở triều đại Joseon, người nổi tiếng có võ thuật cao cường. ",
//                "Dạ Quỷ là một câu chuyện về hoàng tử Lee (do Huyn Bin thủ vai) ở triều đại Joseon, người nổi tiếng có võ thuật cao cường. Trở về sau khoảng thời gian dài bị đày ải bởi nhà Thanh (Trung Quốc), Ngài đau lòng chứng kiến cả quê hương chìm trong một đại dịch của những “ác quỷ bóng đêm”. Liệu rằng vị hoàng tử Lee có ngăn được cơn cuồng nộ của đội quân quỷ dữ này và cứu được giang sơn?",
//                5,
//                "https://youtu.be/Sqb-cQsD0bM",
//                "https://i.ytimg.com/vi/7LcnULw3zqY/maxresdefault.jpg",
//                "http://image.phimmoizz.net/film/7561/poster.medium.jpg",
//                "120",
//                "Hàn Quốc",
//                2020
//        );
//        moviceService.save(movice12);
//
//        Movice movice11 = new Movice(
//                "SĂN LÙNG QUÁI VẬT",
//                "Năm Trung Tông thứ 22 khi triều đại Joseon đang bị càn quét bởi trận dịch hạch kinh hoàng",
//                "Năm Trung Tông thứ 22 khi triều đại Joseon đang bị càn quét bởi trận dịch hạch kinh hoàng, đó là khi dân chúng đang chìm trong cảnh đói khổ lầm than với những nỗi kinh hoàng tưởng như không bao giờ chấm dứt. Lòng dân như lửa đốt khi tin đồn về một con quái thú khát máu chỉ chực chờ uống máu và ăn tươi nuốt sống những ai dám bén mảng đến ngọn núi Inwangsan. ",
//                5,
//                "https://youtu.be/0KwF1371Cqw",
//                "http://t.hdviet.com/backdrops/945x530/79bbe4eb05da699ef75675c08bbb44bf.jpg",
//                "http://image.phimmoizz.net/film/7531/poster.medium.jpg",
//                "120",
//                "Hàn Quốc",
//                2020
//        );
//        moviceService.save(movice11);
//
//        Movice movice14 = new Movice(
//                "The Wolverine",
//                "Marvel một lần nữa đưa đến cho khán giả câu chuyện mới đầy hấp dẫn về chàng Người Sói Logan – siêu anh hùng vốn được đông đảo khán giả yêu mến",
//                "Marvel một lần nữa đưa đến cho khán giả câu chuyện mới đầy hấp dẫn về chàng Người Sói Logan – siêu anh hùng vốn được đông đảo khán giả yêu mến. Được đặt sau mốc sự kiện của X-Men: The Last Stand, bộ phim dõi theo hành trình của Logan lưu lạc tới đất nước Nhật Bản xa xôi, nơi anh bị lạc lõng hoàn toàn.",
//                5,
//                "https://www.youtube.com/watch?v=Q2_KXR1X5Lw",
//                "https://afamilycdn.com/k:thumb_w/600/Tnk9vRlUgEMOa9xiFyoQdi0bvg9Omj/Image/2013/05/images637980_The_Wolverine_cuc_chat.2jpg-eb5ff/nguoi-soi-wolverine-tung-trailer-2-nghet-tho.jpg",
//                "https://i.pinimg.com/474x/dd/2a/5d/dd2a5d7f5fbc8b7de66176111109d40b.jpg",
//                "120",
//                "Mỹ",
//                2013
//        );
//        moviceService.save(movice14);
//
//        Movice movice13 = new Movice(
//                "X-Men: Days of Future Past",
//                "X-Men: Ngày cũ của tương lai là một bộ phim siêu anh hùng 2014 dựa tên nhân vật hư cấu X-Men xuất hiện trên Marvel Comics",
//                "Trong phần phim X-Men: Ngày Cũ Của Tương Lai nhóm người đột biến gửi Người sói (Wolverine) về quá khứ trong một nỗ lực tuyệt vọng để thay đổi lịch sử và ngăn chặn một sự kiện mà kết quả của nó có thể gây diệt vong cho cả người thường và người đột biến. Trong phần phim này, cuộc chiến giữa con người và dị nhân sẽ được nhân rộng ra khắp thế giới với sự góp mặt của dàn diễn viên hùng hậu (Patrick Stewart, Ian McKellen, Hugh Jackman, Jennifer Lawrence, Michael Fassbender, Phạm Băng Băng…) và những cảnh quay vô cùng hoành tráng.",
//                5,
//                "https://www.youtube.com/watch?v=pK2zYHWDZKo",
//                "https://img.cinemablend.com/filter:scale/quill/f/3/b/d/7/5/f3bd7564fcaccfc6edd8815b5c81b2d8f4a39c6e.jpg?mw=600",
//                "https://vcdn1-giaitri.vnecdn.net/2014/05/24/X-Men-VNese-Poster-New-1133-1400903942.jpg?w=680&h=0&q=100&dpr=1&fit=crop&s=iyzgT7xXmc1utuwSuObKbQ",
//                "120",
//                "Mỹ",
//                2020
//        );
//        moviceService.save(movice13);
//
//
////        Movice movice15 = new Movice(
////                "name",
////                "title",
////                "content",
////                5,
////                "trailer",
////                "banner",
////                "poster",
////                "120",
////                "Mỹ",
////                2020
////        );
////        moviceService.save(movice15);
//
//    }
}
