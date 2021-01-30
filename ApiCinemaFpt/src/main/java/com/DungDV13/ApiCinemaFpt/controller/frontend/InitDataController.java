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

    @PostConstruct
        public void initData(){

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
//
//
//        Movice movice1 = new Movice(
//                "Deadpool",
//                "Deadpool xoay quanh anh chàng Wade Wilson, một người bị ung thư vô phương cứu chữa được thí nghiệm trở thành dị nhân với khả năng phục hồi siêu tốc giống Wolverine",
//                "Deadpool xoay quanh anh chàng Wade Wilson, một người bị ung thư vô phương cứu chữa được thí nghiệm trở thành dị nhân với khả năng phục hồi siêu tốc giống Wolverine, tuy nhiên Deadpool được rất nhiều fan hâm mộ biết đến như là một nhân vật cực kỳ hài hước với cái mồm không bao giờ ngừng nói nhảm của hắn.",
//                5,
//                "https://www.youtube.com/watch?v=XDEku5lezds",
//                "deadpool_banner.jpg",
//                "deadpool_post.jpg",
//                "109",
//                "Mỹ",
//                2016,
//                1
//        );
//        moviceService.save(movice1);
//
//        Movice movice2 = new Movice(
//                "X-Men: Apocalypse",
//                "X-Men: Apocalypse là bộ phim siêu anh hùng dựa trên X-Men, những nhân vật xuất hiện trong Marvel Comics. Bộ phim là phần tiếp theo của X-Men: Days of Future Past và là phần thứ 9 trong loạt phim X-Men.",
//                "Tổ tiên của dị nhân – Apocalypse kẻ tích tụ được quyền năng bất khả chiến bại trỗi dậy sau ngàn năm ngủ yên…đối đầu với nhóm X-Men và tham vọng thống trị loài người. Apocalypse là dị nhân đầu tiên và hùng mạnh nhất của vũ trụ X-Men, đã tích lũy được rất nhiều quyền năng đột biến khác nhau, trở thành kẻ bất tử và bất khả chiến bại. Sau khi tỉnh dậy từ giấc ngủ hàng ngàn năm hắn cảm thấy thất vọng với thế giới này và năng lực đáng sợ nhất của hắn là khống chế những người khác và biến họ thành kỵ sĩ của mình, nhằm tẩy sạch nhân loại và tạo ra một trật tự thế giới mới và qua đó, hắn sẽ trị vì nó. Số phận của Trái Đất phải đối mặt với tình huống ngàn cân treo sợi tóc, Raven cùng với sự giúp đỡ của Giáo Sư X buộc phải dẫn dắt một đội X-Men trẻ tuổi nhằm chống lại kẻ thù lớn nhất từ trước đến nay và cứu rỗi nhân loại khỏi sự diệt chủng.",
//                5,
//                "https://www.youtube.com/watch?v=COvnHv42T-A",
//                "xmenapocalypse_banner.jpg",
//                "xmenapocalypse_poster.jpg",
//                "147",
//                "Mỹ",
//                2016,
//                1
//        );
//        moviceService.save(movice2);
//
//
//        Movice movice3 = new Movice(
//                "The New Mutans",
//                "The New Mutants là phim điện ảnh Mỹ thuộc thể loại siêu anh hùng pha kinh dị, tác phẩm dựa trên các nhân vật cùng tên trong Marvel Comics",
//                "Năm dị nhân trẻ tuổi phát hiện ra siêu năng lực của mình khi bị giam giữ trong một cơ sở bí mật. Nhóm dị nhân không những phải tìm cách thoát khỏi cơ sở bí mật mà còn phải tự thoát ra khỏi những việc đen tối trong quá khứ.",
//                5,
//                "https://www.youtube.com/watch?v=W_vJhUAOFpI",
//                "the_new_mutans_banner.jpg",
//                "the_new_mutants_poster.jpeg",
//                "99",
//                "Mỹ",
//                2018,
//                1
//        );
//        moviceService.save(movice3);
//
//        Movice movice4 = new Movice(
//                "X-Men Origins: Wolverine",
//                "Người Sói là một phim điện ảnh siêu anh hùng của Mỹ năm 2009 dựa trên nhân vật Wolverine của Marvel Comics.",
//                "Phim Dị Nhân: Người Sói Báo Thù 2009 là phần trước của ba phần Dị Nhân đã phát hành, kể về nhân vật siêu anh hùng Wolverine của Marvel Comics và 20 năm dữ dội trong quá khứ của anh. Trong phim , Logan chính tay giết chết cha ruột của mình, sau khi ông thảm sát gia đình cha nuôi của anh. Logan và người anh Victor Creed đã cùng chạy trốn khắp nơi, và cuối cùng được William Stryker nhận về phục vụ cho đội quân người đột biến đặc biệt của hắn. Sau một trận càn quét ở Châu Phi, Logan giã từ đội quân này và lui về sống ẩn dật cùng bạn gái Silver Fox. Sau 6 năm bình yên, Stryker tìm đến và buộc Logan phải trở về tham gia dự án Weapon X mới của mình. Cùng lúc với việc sở hữu bộ xương từ chất Adamantium, Logan cũng dần mất đi ký ức và bắt đầu một cuộc sống mới. Weapon X đã biến Logan trở thành Wolverine, và người anh Creed cũng mang tên mới là Sabretooth. Tại đây, cuộc chiến thật sự bắt đầu giữa những người đột biến, dưới sự khống chế đầy dã tâm của William Stryker.",
//                5,
//                "https://www.youtube.com/watch?v=8TQ-gD4UCmI",
//                "wolverine_banner.jpg",
//                "wolverine_poster.jpg",
//                "119",
//                "Mỹ",
//                2019,
//                1
//        );
//        moviceService.save(movice4);
//
//        Movice movice5 = new Movice(
//                "X-Men: Days of Future Past",
//                "X-Men: Ngày cũ của tương lai là một bộ phim siêu anh hùng 2014 dựa tên nhân vật hư cấu X-Men xuất hiện trên Marvel Comics. Phim của đạo diễn Bryan Singer và phần tiếp theo của X-Men: The Last Stand 2006 và X-Men: First Class 2011",
//                "Trong phần phim X-Men: Ngày Cũ Của Tương Lai nhóm người đột biến gửi Người sói (Wolverine) về quá khứ trong một nỗ lực tuyệt vọng để thay đổi lịch sử và ngăn chặn một sự kiện mà kết quả của nó có thể gây diệt vong cho cả người thường và người đột biến. Trong phần phim này, cuộc chiến giữa con người và dị nhân sẽ được nhân rộng ra khắp thế giới với sự góp mặt của dàn diễn viên hùng hậu (Patrick Stewart, Ian McKellen, Hugh Jackman, Jennifer Lawrence, Michael Fassbender, Phạm Băng Băng…) và những cảnh quay vô cùng hoành tráng.",
//                5,
//                "https://www.youtube.com/watch?v=pK2zYHWDZKo",
//                "days_of_future_past_banner.jpg",
//                "days_of_future_past_poster.jpg",
//                "152",
//                "Mỹ",
//                2014,
//                1
//        );
//        moviceService.save(movice5);
//
//        Movice movice6 = new Movice(
//                "Avengers 4: Endgame",
//                "Biệt Đội Siêu Anh Hùng 4: Tàn Cuộc (Avengers 4: Endgame) ra mắt vào tháng 4/2019 sẽ giải quyết triệt để những khúc mắc đã vạch ra suốt 22 bộ phim trước đó của Vụ trụ điện ảnh Marvel (MCU)",
//                "Biệt Đội Siêu Anh Hùng 4: Tàn Cuộc (Avengers 4: Endgame) ra mắt vào tháng 4/2019 sẽ giải quyết triệt để những khúc mắc đã vạch ra suốt 22 bộ phim trước đó của Vụ trụ điện ảnh Marvel (MCU). Hai tháng sau đó, Người Nhện 2 là khởi đầu hoàn toàn mới dành cho MCU.<br/>Sau sự kiện Thanos làm cho một nửa vũ trụ tan biến và khiến cho biệt đội Avengers thảm bại, những siêu anh hùng sống sót phải tham gia trận chiến cuối cùng trong Avengers: Endgame.",
//                5,
//                "https://www.youtube.com/watch?time_continue=1&v=JsTxPRKo5Bw&feature=emb_title",
//                "endgame_banner.jpg",
//                "endgame_poster.jpg",
//                "181",
//                "Mỹ",
//                2019,
//                1
//        );
//        moviceService.save(movice6);
//
//        Movice movice7 = new Movice(
//                "Iron Man 3",
//                "Từ sau những sự kiện và những trận chiến đầy ám ảnh trong The Avengers, Tony Stark quay về ở ẩn trong căn biệt thự sang trọng của mình.",
//                "Từ sau những sự kiện và những trận chiến đầy ám ảnh trong The Avengers, Tony Stark quay về ở ẩn trong căn biệt thự sang trọng của mình, tạm thời chờ đợi trong tư cách một tỷ phú giàu có được yêu mến và gác danh phận siêu anh hùng sang một bên.<br/>Tuy nhiên, những hiểm họa mới lại tiếp tục xuất hiện dưới bóng ma bao trùm của một quái nhân, đồng thời cũng là một thiên tài về công nghệ - The Mandarin. Người bạn thân trong lực lượng quân đội Hoa Kỳ của Tony - James Rhodes cần tới sự giúp đỡ của anh và những bộ giáp siêu việt.<br/>Mọi chuyện không hề dễ dàng như Tony và James tưởng tượng: dưới sức mạnh thần bí của mười chiếc nhẫn vũ trụ, The Mandarin đã đánh bại \"Người Sắt\", đồng thời khiến siêu anh hùng - tỷ phú trở thành kẻ mất trí nhớ...",
//                5,
//                "https://www.youtube.com/watch?v=P6uTPVyopXo",
//                "ironman3_banner.jpg",
//                "ironman3_poster.jpg",
//                "109",
//                "Mỹ",
//                2013,
//                1
//        );
//        moviceService.save(movice7);
//
//        Movice movice8 = new Movice(
//                "Thor 3: Ragnarok",
//                "Sau khi Loki Loki soán ngôi cha Odin, vị thần tinh quái này tiếp tục mở đường nhiễu loạn tiến từ cầu Bifrost vào trong Asgard.",
//                "Ragnarok ám chỉ “tận cùng của vũ trụ”, đồng nghĩa với trận chiến sống còn của chín cõi (Nine Realms). Sau khi Loki Loki soán ngôi cha Odin, vị thần tinh quái này tiếp tục mở đường nhiễu loạn tiến từ cầu Bifrost vào trong Asgard.<br/>Ở bên kia vũ trụ, Thor (Chris Hemsworth) phải bước vào một cuộc chiến đầy khốc liệt với đối thủ mà anh sẽ gặp là một đồng đội cũ đến từ biệt đội Avenger – Hulk. Cuộc tìm kiếm sự sống còn của Thor khiến anh phải chạy đua với thời gian để ngăn chặn Hela (Cate Blanchett) tiêu diệt cả thế giới anh đang sống cùng nền văn minh Asgard",
//                5,
//                "https://youtu.be/0MEmhjJk5e8",
//                "thor3_banner.jpg",
//                "thor3_poster.jpg",
//                "130",
//                "Mỹ",
//                2017,
//                1
//        );
//        moviceService.save(movice8);
//
//        Movice movice9 = new Movice(
//                "Captain America 3: Civil War ",
//                "Captain America: Civil War là câu chuyện theo sau sự kiện Avengers: Age Of Ultron",
//                "Captain America: Civil War là câu chuyện theo sau sự kiện Avengers: Age Of Ultron, các liên minh chính phủ trên toàn thế giới thông qua một hiệp ước được thiết lập để điều chỉnh hoạt động của tất cả siêu anh hùng. Điều này gây ra sự phân cực trong nội bộ nhóm Avengers, tạo nên hai phe gồm Iron Man và Captain America, gây ra một trận chiến sử thi giữa những người đồng đội",
//                5,
//                "https://youtu.be/dKrVegVI0Us",
//                "CaptainAmerica_banner.jpg",
//                "CaptainAmerica_poster.jpg",
//                "147",
//                "Mỹ",
//                2016,
//                1
//        );
//        moviceService.save(movice9);
//
//        Movice movice10 = new Movice(
//                "Captain Marvel ",
//                " Captain Marvel là một cuộc phiêu lưu hoàn toàn mới đến với một thời kỳ chưa từng xuất hiện trong vũ trụ điện ảnh Marvel",
//                "Lấy bối cảnh những năm 90s, Captain Marvel là một cuộc phiêu lưu hoàn toàn mới đến với một thời kỳ chưa từng xuất hiện trong vũ trụ điện ảnh Marvel. Bộ phim kể về con đường trở thành siêu anh hùng mạnh mẽ nhất vũ trụ của Carol Danvers. Bên cạnh đó, trận chiến ảnh hưởng đến toàn vũ trụ giữa tộc Kree và tộc Skrull đã lan đến Trái Đất, liệu Danvers và các đồng minh có thể ngăn chặn binh đoàn Skrull cũng như các thảm họa tương lai?",
//                5,
//                "https://youtu.be/IIIgZI8QDc8",
//                "CaptainMarvel_banner.jpg",
//                "CaptainAmerica_poster.jpg",
//                "123",
//                "Mỹ",
//                2019,
//                1
//        );
//        moviceService.save(movice10);
//
//
//        Movice movice11 = new Movice(
//                "SÁT THỦ VÔ CÙNG CỰC",
//                "Xoay quanh Joon, chàng cựu điệp viên của NIS, \"dứt áo ra đi\" khỏi tổ chức, ngày đêm cống hiến với sở thích truyện tranh.",
//                "Xoay quanh Joon, chàng cựu điệp viên của NIS, \"dứt áo ra đi\" khỏi tổ chức, ngày đêm cống hiến với sở thích truyện tranh. Vòng xoáy \"cơm áo gạo tiền\" nào phải dễ, truyện anh sáng tác, chẳng mấy ai quan tâm, cho đến khi, anh tự kể lại trải nghiệm điệp viên của mình, kể chậm rãi, từng từ một, lượt view tăng lên, nhưng kéo theo đó, là bao rắc rối ập đến khi thông tin mật đều được phơi bày.",
//                5,
//                "https://youtu.be/i8X6Snxa65U",
//                "banner-sat-thu-vo-cuc.jpg",
//                "poster-sat-thu-vo-cuc.jpg",
//                "110",
//                "Hàn Quốc",
//                2019,
//                1
//        );
//        moviceService.save(movice11);
//
//        Movice movice12 = new Movice(
//                "ÔNG BẠN GĂNG-TƠ",
//                "Ông Bạn Găng-Tơ kể về tay giang hồ hay khoe mẽ Young-Ki với ước mơ có một cuộc sống “đỉnh cao” bằng cách thường xuyên chơi vé số trực tuyến.",
//                "Ông Bạn Găng-Tơ kể về tay giang hồ hay khoe mẽ Young-Ki với ước mơ có một cuộc sống “đỉnh cao” bằng cách thường xuyên chơi vé số trực tuyến.Trong một lần quậy phá, gã bị tòa tuyên án 150 giờ lao động công ích. Nhiệm vụ của Young-Ki chính là chăm sóc cho vị Jang-Soo - một vị luật sư nổi tiếng và giàu có nay lại bại liệt toàn thân và sắp chết sau cơn bạo bệnh.",
//                5,
//                "https://youtu.be/fw_37uXxENM",
//                "banner-ong-ban-gansert.jpg",
//                "poster-ong-ban-gansert.jpg",
//                "117",
//                "Hàn Quốc",
//                2018,
//                1
//        );
//        moviceService.save(movice12);
//
//        Movice movice13 = new Movice(
//                "SỞ THÚ THOÁT Ế",
//                "Một luật sự tập sự tên Tae-soo (Ahn Jae-hong) được công ty giao nhiệm vụ tiếp quản việc kinh doanh của vườn thú khi gần như tất cả các con thú đã bị bán đi.",
//                "Một luật sự tập sự tên Tae-soo (Ahn Jae-hong) được công ty giao nhiệm vụ tiếp quản việc kinh doanh của vườn thú khi gần như tất cả các con thú đã bị bán đi. Một ý tưởng táo bạo đã được đưa ra để cứu vườn thú “thoát ế”: Các nhân viên phải mặc các bộ đồ thú và diễn như những con thú “thứ thiệt”. Mọi chuyện bất ngờ vượt khỏi tầm kiểm soát khi sở thú đột nhiên trở thành hiện tượng trên mạng xã hội. Các nhân viên phải làm gì nếu mọi chuyện vỡ lở?",
//                5,
//                "https://youtu.be/ie6lVdIWAHk",
//                "banner-so-thu-thoat-e.jpg",
//                "poster-so-thu-thoat-e.jpg",
//                "115",
//                "Hàn Quốc",
//                2019,
//                1
//        );
//        moviceService.save(movice13);
//
//        Movice movice14 = new Movice(
//                "BIỆT ĐỘI BẤT HẢO",
//                "Đội Điều Tra Đặc Biệt do đội trưởng Oh Gu-tak thành lập, với tiêu chí không cần quan tâm phương pháp tốt xấu, chỉ cần “bắt sống bọn tội phạm”.",
//                "Đội Điều Tra Đặc Biệt do đội trưởng Oh Gu-tak thành lập, với tiêu chí không cần quan tâm phương pháp tốt xấu, chỉ cần “bắt sống bọn tội phạm”. Thành viên gạo cội nhất của đội là tay đấm Park Woong-chul, người đã vào tù cũng là đại ca được tôn kính. Hai thành viên mới được chiêu mộ thêm là mỹ nữ chân dài bốc lửa - thiên tài lừa đảo Kwak No-soon và tay cảnh sát lì lợm đang lĩnh án Ko Yoo-sung.",
//                5,
//                "https://youtu.be/z6ukWvQ-YH8",
//                "banner-biet-doi-bat-hao.jpg",
//                "poster-biet-doi-bat-hao.jpg",
//                "130",
//                "Hàn Quốc",
//                2020,
//                1
//        );
//        moviceService.save(movice14);
//
//        Movice movice15 = new Movice(
//                "TRÙM, CỚM VÀ ÁC QUỶ",
//                "Có ai ngờ được rằng Jang Dong Su - một tay trùm khét tiếng cũng có lúc trở thành nạn nhân của một kẻ giết người máu lạnh?!",
//                "Có ai ngờ được rằng Jang Dong Su - một tay trùm khét tiếng cũng có lúc trở thành nạn nhân của một kẻ giết người máu lạnh?! Chính sự kiện này đã mở ra một cuộc hợp tác bất đắc dĩ giữa ông trùm và gã cớm để truy bắt hung thủ. Tất nhiên, mặc dù phối hợp với nhau nhưng hai bên vẫn ngấm ngầm sử dụng những luật lệ và giữa cho mình những bí mật riêng. Liệu cuộc vây bắt này sẽ diễn ra như thế nào? Ai sẽ người dành được chiến thắng cuối cùng?",
//                5,
//                "https://youtu.be/Nn3dGGRkObo",
//                "banner-trum.jpg",
//                "poster-trum.jpg",
//                "110",
//                "Hàn Quốc",
//                2015,
//                1
//        );
//        moviceService.save(movice15);
//
//        Movice movice16 = new Movice(
//                "DẠ QUỶ",
//                "Dạ Quỷ là một câu chuyện về hoàng tử Lee (do Huyn Bin thủ vai) ở triều đại Joseon, người nổi tiếng có võ thuật cao cường. ",
//                "Dạ Quỷ là một câu chuyện về hoàng tử Lee (do Huyn Bin thủ vai) ở triều đại Joseon, người nổi tiếng có võ thuật cao cường. Trở về sau khoảng thời gian dài bị đày ải bởi nhà Thanh (Trung Quốc), Ngài đau lòng chứng kiến cả quê hương chìm trong một đại dịch của những “ác quỷ bóng đêm”. Liệu rằng vị hoàng tử Lee có ngăn được cơn cuồng nộ của đội quân quỷ dữ này và cứu được giang sơn?",
//                5,
//                "https://youtu.be/Sqb-cQsD0bM",
//                "banner-da-quy.jpg",
//                "poster-da-quy.jpg",
//                "129",
//                "Hàn Quốc",
//                2019,
//                1
//        );
//        moviceService.save(movice16);
//
//        Movice movice17 = new Movice(
//                "THE KING'S MAN",
//                "Tiếp tục là những nhiệm vụ tưởng chừng như bất khả thi nhằm giải cứu nhân loại của tổ chức mật vụ nổi tiếng bậc nhất màn ảnh rộng.",
//                "Tiếp tục là những nhiệm vụ tưởng chừng như bất khả thi nhằm giải cứu nhân loại của tổ chức mật vụ nổi tiếng bậc nhất màn ảnh rộng. Đặc biệt lần này, đối thủ của họ gồm một nhóm người được coi là những kẻ khủng bố và tàn bạo hàng đầu",
//                5,
//                "https://www.youtube.com/watch?v=AZQQsyW6rpM&feature=emb_logo",
//                "banner-kings-man.jpg",
//                "poster-kings-man.jpg",
//                "129",
//                "Anh",
//                2020,
//                0
//        );
//        moviceService.save(movice17);
//
//        Movice movice18 = new Movice(
//                "TENET",
//                "Với cái tên ấn tượng - Tenet, bộ phim mới của Christopher Nolan được kỳ vọng khiến khán giả ồ ạt quay trở lại rạp sau đợt dịch Covid-19",
//                "Với cái tên ấn tượng - Tenet, bộ phim mới của Christopher Nolan được kỳ vọng khiến khán giả ồ ạt quay trở lại rạp sau đợt dịch Covid-19",
//                5,
//                "https://www.youtube.com/watch?time_continue=153&v=zbVaIdBNFDc&feature=emb_logo",
//                "banner-tenet.jpg",
//                "poster-tenet.jpeg",
//                "129",
//                "Anh",
//                2020,
//                0
//        );
//        moviceService.save(movice18);
//
//        Movice movice19 = new Movice(
//                "BLOODSHOT",
//                "Bloodshot vốn là một cựu binh mang tên Ray Garrison. Không may hy sinh trong lúc ra trận, anh được tập đoàn RST hồi sinh với một thân phận và siêu năng lực hoàn toàn khác biệt.",
//                "Bloodshot vốn là một cựu binh mang tên Ray Garrison. Không may hy sinh trong lúc ra trận, anh được tập đoàn RST hồi sinh với một thân phận và siêu năng lực hoàn toàn khác biệt. Bằng hàng triệu nanobot chạy trong huyết quản, Bloodshot giờ đây sở hữu siêu sức mạnh, tốc độ, sức bền và khả năng hồi phục thần tốc hơn cả Deadpool.",
//                5,
//                "https://www.youtube.com/watch?v=d6EzPG4_2zE",
//                "Bloodshot-banner.jpg",
//                "Bloodshot-poster.jpg",
//                "129",
//                "Anh",
//                2020,
//                0
//        );
//        moviceService.save(movice19);
    }
}
