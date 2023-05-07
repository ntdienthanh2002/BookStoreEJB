create database BookStoreEJB
use BookStoreEJB

create table Authors (AuthorID int primary key identity(1, 1) not null,
					AuthorName nvarchar(50) not null)

create table Publishers (PublisherID int primary key identity(1, 1) not null,
						PublisherName nvarchar(100) not null)

create table Languages (LanguageID int primary key identity(1, 1) not null,
					LanguageName nvarchar(100) not null)

create table Categories (CategoryID int primary key identity(1, 1) not null,
					CategoryName nvarchar(60) not null)

create table Products (ProductID int primary key identity(1, 1) not null,
					ProductName nvarchar(150) not null,
					AuthorID int foreign key (AuthorID) references Authors(AuthorID) not null,
					PublisherID int foreign key (PublisherID) references Publishers(PublisherID) not null,
					LanguageID int foreign key (LanguageID) references Languages(LanguageID) not null,
					CategoryID int foreign key (CategoryID) references Categories(CategoryID) not null,
					ProductImage nvarchar(255) not null,
					ProductSize nvarchar(20) not null,
					ProductPage int check (ProductPage > 0) not null,
					ProductForm nvarchar(20) check (ProductForm in ('Hardcover', 'Softcover')) not null,
					ProductPrice money check (ProductPrice > 0) not null,
					ProductQuantity int check (ProductQuantity >= 0) not null,
					ProductDescription ntext not null,
					ProductDiscount int check (ProductDiscount >= 0) not null,
					ProductSell int check (ProductSell >= 0) not null)

create table UserAccounts (UserAccountID int primary key identity(1, 1) not null,
								UserAccountUsername nvarchar(50) not null,
								UserAccountPassword nvarchar(50) not null,
								UserAccountEmail nvarchar(100) not null,
								UserAccountPhone int null,
								UserAccountAddress nvarchar(255) null)
								
create table AdminAccounts (AdminAccountID int primary key identity(1, 1) not null,
								AdminAccountUsername nvarchar(50) not null,
								AdminAccountPassword nvarchar(50) not null)

create table Feedbacks (FeedbackID int primary key identity(1, 1) not null,
					UserAccountID int foreign key (UserAccountID) references UserAccounts(UserAccountID) not null,
					ProductID int foreign key (ProductID) references Products(ProductID) null,
					FeedbackDate date not null,
					FeedbackContent ntext not null)

create table Orders (OrderID int primary key identity(1, 1) not null,
					UserAccountID int foreign key (UserAccountID) references UserAccounts(UserAccountID) not null,
					OrderDate date not null,
					OrderDeliveryDate date not null,
					OrderAddress nvarchar(255) not null,
					OrderPhone int not null,
					OrderNote ntext null,
					OrderStatus int check (OrderStatus in (0, 1, 2, 3)) not null)

create table OrderDetails (OrderID int foreign key (OrderID) references Orders(OrderID) not null,
							ProductID int foreign key (ProductID) references Products(ProductID) not null,
							OrderDetailPrice money check (OrderDetailPrice >= 0) not null,
							OrderDetailQuantity int check (OrderDetailQuantity > 0) not null,
							OrderDetailDiscount int check (OrderDetailDiscount >= 0) not null,
							CONSTRAINT PK_Order_Details PRIMARY KEY (OrderID, ProductID))
							
insert into Authors values ('Ho Chi Minh'),
						('To Hoai'),
						('Many authors'),
						('David George Haskell'),
						('Chris Guillebeau'),
						('Nguyen Nhat Anh'),
						('Nguyen Van Khoa'),
						('Fujiko F. Fujio'),
						('V. E. Schwab'),
						('J.K.Rowling'),
						('Thich Nhat Hanh'),
						('John Marrs'),
						('Khotudien'),
						('Amanda Li'),
						('Jun Pham')

insert into Publishers values ('Kim Dong'),
							('Tre'),
							('Thanh Nien'),
							('Phu Nu Viet Nam'),
							('The Gioi'),
							('Van hoc'),
							('Hong Duc'),
							('Lao Dong'),
							('Pearson Education'),
							('Hachette'),
							('Bloomsbury Publishing'),
							('Dan Tri'),
							('Titan Books'),
							('Macmillan'),
							('Van Hoa - Van Nghe')

insert into Languages values ('Vietnamese'),
							('English'),
							('French'),
							('German'),
							('Japanese'),
							('Korean'),
							('Chinese'),
							('Russian'),
							('Indian'),
							('Australian'),
							('Spanish')

insert into Categories values ('History'),
							('Literary'),
							('Children'),
							('Life skills'),
							('Educational psychology'),
							('Economics/Business'),
							('Spirituality/Religion'),
							('Environmental science'),
							('Poem'),
							('Memoir'),
							('Short Story')

insert into Products values ('Lich su Viet Nam bang tranh: Tran Hung Dao', 3, 2, 1, 1, '../images/products/lich-su-viet-nam-bang-tranh-tran-hung-dao.jpg', '24 x 19', 80, 'Softcover', 6, 15, 'The Vietnamese History with pictures series tells the story of Vietnam''s history in a concise, engaging, and systematic style through beautiful stories and pictures. This new version is very elaborately colored. The book is carefully designed, with beautiful intestines and covers, both modern and bold Vietnamese identity. The invasion and expansionist dream of the Nguyen Mong invaders put Dai Viet before the challenge of survival. But it was in that difficult context that the patriotism of the royal family, mandarins and people of Dai Viet had the opportunity to promote. Besides those who were born with treason, Dai Viet at that time did not lack patriotic hearts, but the most prominent was the National Duke of Thiet Tran Hung Dao. For the sake of the country, to put aside private enmity, because of great affairs, to put aside grudges, to know how to use talented people regardless of the past, to recommend talented people who do not care about their background..., besides being talented in military maneuvers to make a Hung Dao Vuong Martial arts and martial arts, full of talent and integrity, are highly praised by history books.', 0, 38),
							('Nhat ky trong tu', 1, 1, 1, 9, '../images/products/nhat-ky-trong-tu.jpg', '13 x 19', 291, 'Softcover', 15, 33, 'Nhat ky trong tu is a literary work consisting of 133 poems in Chinese characters written by Ho Chi Minh from August 29, 1942 to September 10, 1943. In addition, the last part of the document is a book and newspaper reading that summarizes military and cultural information that Uncle Ho read in books and newspapers. Nhat ky trong tu not only records scenes of prison life, but also has the meaning of denouncing the harsh prison system of Chiang Kai-shek''s government. On October 1, 2012, the Prime Minister of the Socialist Republic of Vietnam issued a decision to recognize the national treasure for Nhat ky trong tu.', 0, 2),
							('Khuc hat cua cay', 4, 5, 1, 8, '../images/products/khuc-hat-cua-cay.jpg', '15.5 x 23.5', 329, 'Softcover', 7, 1224, 'Taking nature as the central character, through this work, Haskell let the trees speak their voices about the Earth, people and the dependent relationship of the two parties. Trees represent the soul of the forest, showing the law of cause and effect on the development of creatures in the universe. From a biological point of view, the green tree itself has brought pure beauty thanks to its internal structure, operating mechanism and connection with other natural organisms, that beauty also hides the thickness of the tree. history and culture, bearing the memory of an era, a tribe or simply keeping a good tradition of a family...', 0, 6),
							('Tho va thien', 3, 5, 1, 7, '../images/products/tho-va-thien.jpg', '13 x 21', 216, 'Softcover', 6, 1297, 'Tho va thien is a collection of various views on meditation from more than 30 sages and masters in human history. Tho va thien gives us a diverse perspective from different religious and spiritual perspectives, from the perspective of the Buddha thousands of years ago to the views of modern Zen masters in the 20th century. By analyzing different spiritual trends, readers have the opportunity to compare, feel and discover the science of meditation with their own thinking. Understand meditation according to your own adaptive path and reap valuable advice from the treasure trove of those who have already achieved enlightenment on the path.', 0, 2),
							('Cay tien', 5, 5, 1, 6, '../images/products/cay-tien.jpg', '14 x 20.5', 337, 'Softcover', 8, 2134, 'The book uses an engaging voice-over and an engaging story mixed with humor to convey the main message: getting rich is not difficult if you are willing to work hard and have the courage to go beyond your comfort zone. The whole story revolves around Jake''s story - engaging and inspiring, then gently draws insights and practical action steps from that story. This is considered a new breeze of the book Cay tien, if placed in the financial book genre, which is stereotyped as dry and unattractive. The book can be viewed as a useful guide full of great money-making ideas, as well as an engaging fiction book that will keep you entertained while reading.', 0, 2),
							('Tu dien muon loai: Chung minh thich bay luon', 3, 5, 1, 3, '../images/products/tu-dien-muon-loai-chung-minh-thich-bay-luon.jpg', '25 x 25', 32, 'Softcover', 3, 1018, 'Did you know, in addition to birds, there are other small friends in the group of mammals, reptiles or fish that have the ability to fly? Do you know the secrets of the insect world? Friends who are small but have the largest population on the planet. Many interesting things are waiting for you in this book. Flip through the book to get acquainted and discover the lives of these friends! In particular, in each book there are extremely cute stickers of 14 new friends.', 0, 0),
							('Cho toi xin mot ve di tuoi tho', 6, 2, 1, 3, '../images/products/cho-toi-xin-mot-ve-di-tuoi-tho.jpg', '13 x 20', 208, 'Hardcover', 9, 8, 'In Cho Toi Xin Mot Ve Di Tuoi Tho, writer Nguyen Nhat Anh invites readers to take a train back to visit the childhood and cute friendship of 4 children. The cute games in childhood, the honest, straightforward and intelligent personality, the dreams of freedom in the heart... make the book able to make parents worry and then breathe a sigh of relief. Not only suitable for young readers, the book can also be attractive and really useful for adults in relation to their children.', 20, 7),
							('De Men phieu luu ky', 2, 1, 1, 2, '../images/products/de-men-phieu-luu-ky.jpg', '24 x 32', 112, 'Hardcover', 12, 20, 'For more than half a century since it was first published in 1941, De Men Phieu Luu Ky is one of To Hoai''s favorite works. The work has been reprinted many times, translated into more than 20 languages around the world and is always well received by younger generations of readers. The work has been published in various formats. In which, the book De Men Phieu Luu Ky includes many vivid illustrations by artist Ta Huy Long - an artist specializing in drawing for children''s books. By skillfully using watercolors, painter Ta Huy Long has brought to life this immortal work of writer To Hoai. The book will therefore be a beautiful gift in both form and content, a meaningful and useful gift that parents give to their good children.', 30, 4),
							('Than thoai Hy Lap', 7, 6, 1, 2, '../images/products/than-thoai-hy-lap.jpg', '16 x 24', 1030, 'Softcover', 16, 8, 'Than thoai Hy Lap, a cultural heritage of the Greek people, has long become an extremely valuable universal value of the cultural heritage of mankind. In human culture, from the paintings and statues of artists of antiquity, the Renaissance, the 17th century, the eighteenth century, the nineteenth century and even our twentieth century to a treatises, a play, a book of stories, all have exploited themes, plots, characters, and events in Greek mythology. In literature, in the press, idioms and classics from Greek mythology are commonly used as a familiar signal.', 40, 0),
							('Nobita o xu so nghin le mot dem', 8, 1, 1, 3, '../images/products/nobita-o-xu-so-nghin-le-mot-dem.jpg', '13 x 18', 244, 'Softcover', 5, 15, 'Nobita o xu so nghin le mot dem is the 12th work in the beloved animated series "Doraemon" adapted from the original manga by author Fujko.F.Fujio. This story is set in the world of "One Thousand and One Nights" that I have loved since I was a child. For a long time, I have cherished the idea of integrating this mysterious fictional world into the comic book genre. And now, invite them to join the adventure to the magical land of Doraemon friends!', 5, 0),
							('The Near Witch', 9, 13, 2, 2, '../images/products/the-near-witch.jpg', '13 x 19.8', 320, 'Hardcover', 25, 9, 'The Near Witch is an old story told to frighten children. If the wind calls at night, you are not heard. The wind is lonely, and always looking for a companion. There are no strangers in Near town. These are facts Lexi has heard all her life. But when a real stranger, a guy who seemed to fade like smoke, showed up outside her house in the evening, she knew that at least one of these statements was no longer true. The next night, the children of Near town begin to disappear from their beds and the mysterious boy is suspected. As the hunt for the children increases, Lexi also needs to know about the witch, which can be more than just a bedtime story, about the wind that seems to speak through walls at night. and about the history of this unknown boy. Part fairy tale, part love story, Victoria Schwab''s debut novel is completely original but still painfully familiar: a song you''ve heard long ago, a whisper of the wind. and a dream you will soon forget.', 5, 0),
							('Harry Potter and the Half-Blood Prince', 10, 11, 2, 2, '../images/products/harry-potter-and-the-half-blood-prince.jpg', '12.9 x 19.8', 560, 'Softcover', 17, 5, 'When Dumbledore arrives at Privet Drive one summer night to collect Harry Potter, his wand hand is blackened and shrivelled, but he does not reveal why. Secrets and suspicion are spreading through the wizarding world, and Hogwarts itself is not safe. Harry is convinced that Malfoy bears the Dark Mark: there is a Death Eater amongst them. Harry will need powerful magic and true friends as he explores Voldemort''s darkest secrets, and Dumbledore prepares him to face his destiny. These new editions of the classic and internationally bestselling, multi-award-winning series feature instantly pick-up-able new jackets by Jonny Duddle, with huge child appeal, to bring Harry Potter to the next generation of readers. It''s time to PASS THE MAGIC ON...', 0, 0),
							('Mot nua dich thuc', 12, 12, 1, 2, '../images/products/mot-nua-dich-thuc.jpg', '15.5 x 24', 406, 'Softcover', 10, 10, 'For a long time, finding a soulmate, the perfect piece of our life is not an easy thing. But now, thanks to a new scientific discovery, just a simple gene test can ensure anyone can find "the real half", without having to go through broken relationships with others. inappropriate object. Millions of people around the world have chosen this way, including Mandy, Christopher, Jade, Nick and Ellie. All believe that they have found a great love, who can accompany them until the end of their lives. But is it that simple, when even soulmates can hide terrifying secrets? Mot Nua Dich Thuc will leave you wondering if genetics can really determine love and if such a story is possible in the future.', 0, 0),
							('Adventures In Moominvalley', 14, 14, 2, 3, '../images/products/adventures-in-moon-valley.jpg', '22.8 x 27.8', 128, 'Hardcover', 16, 40, 'Beautifully designed, lavishly produced and richly illustrated with captivating artwork and lively, witty writing, Adventures in Moominvalley is the first of three storybook companions to the highly anticipated animated TV series, Moominvalley. The show is voiced by a stellar cast including Kate Winslet, Rosamund Pike, Jennifer Saunders, Richard Ayoade, and Matt Berry and tells the adventures of nine-year-old Moomintroll, his parents, Moominmamma and Moominpappa and their eclectic and happy band of friends - Little My, Snufkin, Snork Maiden, the Hattifatteners and other famous characters from the classic stories. Set in the picturesque Moominvalley and centred around the tall, round blue Moomin house where the Moomins live, the adventures in this collection are based on the TV episodes, which derive closely from the warm and whimsical Moomin world created by the celebrated writer and artist Tove Jansson.', 0, 0),
							('365 - Nhung nguoi la quen thuoc', 15, 15, 1, 10, '../images/products/365-nhung-nguoi-la-quen-thuoc.jpg', '18 x 24', 200, 'Softcover', 11, 365, 'The book is about the journey to the common dream of the 365 band: Isaac, Jun Pham, Will and S.T Son Thach. This book is a precious 365 gift to Stellaris – the audience that has loved 365 over the years. They are also the most honest diary lines that fully record the difficulties, happiness, failures, successes that have been passed along with a burning passion for singing so that people from strangers become familiar, from hate to love, accept each other''s shortcomings, learn to lower the ego to integrate. This book has shown us the hidden corners, behind that glory, how you have to go through the difficulties, the pain, the bitterness, the loss, in order to be able to be together, to complete unfinished dreams... There is a special chapter recorded by the members themselves in their own handwriting. Those are the thanks from the bottom of their hearts to their family, the management company - VAA, the rest of the members and Stellaris.', 0, 0),
							('Neu nhu khong the noi neu nhu', 15, 8, 1, 11, '../images/products/neu-nhu-khong-the-noi-neu-nhu.jpg', '12 x 20', 152, 'Softcover', 8, 365, 'In everyone''s life, surely everyone has regretted something. At those times, people often use the phrase "What if...": "If I wasn''t like that before!", "If only I had met you earlier!", "If only time could be turned back!",... It is a saying expressing disappointment and regret. But the result clause will forever never come true when the conditional is past events. Everything that comes and goes will go like the wind. What stays are just happy memories, so let''s live and appreciate the present.', 0, 0),
							('Co ai giu gium nhung lang quen', 15, 15, 1, 11, '../images/products/co-ai-giu-gium-nhung-lang-quen.jpg', '12 x 20', 175, 'Softcover', 7, 365, 'I consider myself an artist because my main job is an artist. Most of all, my habits have always been in favor of people with more developed right brains than left brains. I love things that are emotional, belong to the vague... And I also love to read and write. Reading is a hobby I will never get bored of. Same with writing, I will never find myself a reason to stop this habit. I write to save memories that I fear one day I will suddenly forget. Memories that, in my opinion, will be precious things that no gem can replace. When you lose material things, you can get them back with diligence and patience. But when you lose your memory, you will never have faith and hope, there is nothing left to rely on to continue on the path of life. Just because I''m willing to keep my memories with me doesn''t mean I live in the past. Someone once said never to live for the past too much, but to live for the present and future ambitions. But in my opinion, the past is something to keep, whether you like it or not, because it is the root, the source for the sublimation and dreams in life. You can''t live without remembering someone, you can''t exist if you forget where you came from, and you can''t be successful without yesterday''s stumbles and failures... On the busy road of life, we must have forgotten many things. Forget the sound of true love, forget to say thank you, forget to say sorry, forget to share joys, forget to share sorrows, forget to laugh when you''re happy, forget to cry when you''re desperate, forget to hold your hand when you need it , forget the hug when forgiving, forget to ask about your loved ones, forget you are still young, forget your parents are really old, forget people are waiting, forget to listen to advice, forget to praise a delicious dish ... Forgetting doesn''t make you cruel. It seems to be the inevitable part of life. Of course, you don''t have to feel guilty when you suddenly forget something because no one blames you. In fact, it is impossible to remember everything that we accidentally go through every day. How do we think about family when we are focused on an important project. We also can''t have time to care about a beggar on the street when we are busy with food and money... But at some point, we accidentally come across a familiar image: a child''s toy, a childhood dish, a past scene, an old and weak hand, a gray head Only then do we realize that we have forgotten many important things... I write these lines and the following paragraphs not intending to recall painful pasts or show much understanding about life. The lines of emotions in this little book are mainly just to preserve the forgotten memories, the memories in me like to remind myself that even if I shrug my shoulders because of the burdens of the past, I promise to just let go. Take a moment to relieve fatigue and then carry it with you for the rest of your life. Because somewhere along the way, I don''t forget that I''ve lost a lot of things that I can''t turn back to pick up...', 0, 0),
							('Thuc day anh van la mo', 15, 15, 1, 11, '../images/products/thuc-day-anh-van-la-mo.jpg', '12 x 20', 162, 'Softcover', 8, 365, 'I am a person who loves to dream. Whether it''s a dream at night or during the day, whether it''s a good dream or a nightmare, I always write down what I remember right away in the notebook that is on the nightstand when I wake up. I think these ideas will be used by me at some point in my career. As an idealist, I have always believed that in this world, besides our life, there are many other lives that exist in parallel. Maybe it''s an underground world, a world floating in the clouds, a tiny world in a tiny grain of sand, or closer, a world as familiar as we are but inhabited by people. deceased person. Waking up, you''re still a dream of being born when I was lucky enough to enter one of those worlds through an unforgettable dream. It must have been a familiar place but very strange, fanciful but also very real... Only thing for sure was that time moved very slowly. After waking up, even though I knew it was just a meaningless dream, I was really caught up in those encounters, a short but emotional adventure. Later, although I tried very hard, I could not find the dream that day. Just like love, the most beautiful and wonderful things will eventually become memories, even if we want to, we can''t hold on if we miss a moment when we accidentally let go of the beautiful memories of the past together', 0, 0)
							
insert into UserAccounts values ('Dien Thanh', 'thanh1234', 'ntdienthanh1011@gmail.com', 706991366, 'Can Tho'),
									('Tam Duyen', '1501', 'phuoctamduyen151@gmail.com', 0, ''),
									('Lac Gia Tue', '1610', 'lacgiatue1610@gmail.com', 0, ''),
									('Lac An Nhi', '2909', 'lacannhi2909@gmail.com', 0, ''),
									('Lac Hàn Vu', '0610', 'lachanvu0610@gmail.com', 0, '')

insert into AdminAccounts values ('Dien Thanh', 'thanh1234'),
									('Tam Duyen', 'duyen5678')

insert into Feedbacks values (1, 1, '2021-11-21', 'In addition to the heroic battles, he also once robbed his wife, making his descendants still admire for thousands of generations'),
						(2, 2, '2021-11-19', 'Uncle Ho is always a shining example'),
						(4, 8, '2021-11-18', 'Good book, nice packaging'),
						(5, 4, '2021-11-15', 'Well packed, fast delivery, good!'),
						(1, 1, '2021-10-26', 'How heroic is the history of Vietnam!'),
						(3, 1, '2021-11-27', 'The top of the spire'),
						(1, 8, '2021-11-27', 'Good'),
						(2, 1, '2021-11-27', 'Woaaaaaaaaaaaaaaaaaaaaaaaaaa'),
						(1, 1, '2021-11-27', 'Goodluck'),
						(1, 7, '2021-11-27', 'Meaningful'),
						(1, 6, '2021-11-27', 'Thank you BookStore for bringing good books'),
						(4, 2, '2021-11-27', 'Thank you!'),
						(1, 1, '2021-12-01', 'Good'),
						(1, 1, '2021-12-01', 'Idol'),
						(3, 1, '2021-12-01', 'Wowwwwwwwwwwww'),
						(5, 12, '2021-12-02', 'Thank you!'),
						(1, 10, '2021-12-02', 'Wonderful')

insert into Orders values (1, '2021-12-01', '2021-12-08', 'Can Tho', 706991366, '', '1'),
							(1, '2021-12-01', '2021-12-10', 'Can Tho', 706991366, 'Remember to pack carefully. Thanks!', '1'),
							(1, '2021-12-01', '2021-12-05', 'Can Tho', 706991366, '', '2'),
							(1, '2021-12-01', '2021-12-06', 'Can Tho', 706991366, '', '3'),
							(1, '2021-12-01', '2021-12-14', 'Can Tho', 706991366, '', '0'),
							(1, '2021-12-02', '2021-12-10', 'Can Tho', 706991366, '', '2')

insert into OrderDetails values (1, 1, 6, 2, 0),
								(1, 2, 15, 1, 0),
								(1, 7, 9, 2, 20),
								(1, 8, 12, 1, 30),
								(2, 1, 6, 2, 0),
								(2, 2, 15, 1, 0),
								(2, 7, 9, 2, 20),
								(2, 8, 12, 1, 30),
								(3, 1, 6, 1, 0),
								(3, 4, 6, 1, 0),
								(3, 7, 9, 1, 20),
								(3, 8, 12, 1, 30),
								(4, 1, 6, 1, 0),
								(4, 3, 7, 1, 0),
								(4, 4, 6, 1, 0),
								(4, 8, 12, 1, 30),
								(5, 1, 6, 1, 0),
								(5, 5, 8, 2, 0),
								(6, 1, 6, 31, 0),
								(6, 3, 7, 5, 0),
								(6, 7, 9, 2, 20)