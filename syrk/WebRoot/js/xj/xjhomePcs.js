
if(typeof HomePcs == "undefined" || !HomePcs){
	var HomePcs = {};
};

HomePcs = function(){
	this.pk = Math.random();
};

HomePcs.queryHTML = "";//辖区概况介绍
HomePcs.bjJson = ""; //记录边界json串后退时用到
HomePcs.PcsTjJson = ""; //记录派出所统计json串后退时用到
HomePcs.zzjgdm = "";//记录当前展示的组织机构代码
HomePcs.zzjgmc = "";//记录当前展示的组织机构名称
HomePcs.floatWin = "";//弹出窗口
HomePcs.countZrq = "";//记录该派出所共几个责任区
HomePcs.XqMJ = "";//记录辖区面积
HomePcs.PcsXqMJ = "";//记录派出所辖区面积
HomePcs.mpdzMarkerArr = new Array();//放点对象
HomePcs.eqkg = "0"; //热度分析开关
HomePcs.EventListenerZoom = "";//记录地图监听事件_地图放大缩小
HomePcs.EventListenerPan = "";//记录地图监听事件_平移
HomePcs.Mbr = null;//中心点
//临时变量_红旗派出所专用
HomePcs.jwszrq1 = "121.458446421167,38.951030887067,121.454518523312,38.951862677222,121.452711962488,38.951185217025,121.451561047006,38.950753624281,121.449666413775,38.949875623362,121.446965326090,38.947861530486,121.444197707459,38.947052829525,121.443034632244,38.946826809211,121.442309909975,38.947097773145,121.438252405425,38.944145513805,121.435202507591,38.941280459027,121.434093454650,38.940356247344,121.425538190536,38.940339204292,121.419655681865,38.937029344829,121.415772270775,38.935965128489,121.404111164700,38.935045726380,121.396981207318,38.932857035525,121.388976561220,38.931701243918,121.384013114715,38.930587110708,121.380041950477,38.923309078152,121.375079153281,38.916872433317,121.372410121031,38.914807467591,121.372223679880,38.914527688503,121.372058389884,38.914245994758,121.371929776039,38.913960273848,121.371853097144,38.913668018465,121.371843613793,38.913366723097,121.371909346140,38.913060047984,121.372030817569,38.912765192660,121.372196251457,38.912481985356,121.372395056488,38.912208881935,121.372616636849,38.911944340060,121.372850401226,38.911686818293,121.373094428666,38.911438447128,121.373360016453,38.911205104533,121.373644181535,38.910985044925,121.373943426449,38.910776284399,121.374254252833,38.910576838151,121.374573165920,38.910384720479,121.374896666449,38.910197946579,121.375230785274,38.910026680588,121.375586035468,38.909885268491,121.375956621802,38.909766167675,121.376336525112,38.909661540549,121.376910681084,38.909514599420,121.377287541088,38.909411878856,121.377652651450,38.909296208954,121.377999990308,38.909159752122,121.378323540300,38.908994676164,121.378617278666,38.908793143490,121.378874498261,38.908556199110,121.379092484931,38.908302603783,121.379274844060,38.908034946656,121.379425359094,38.907754925650,121.379547815280,38.907464235087,121.379645996966,38.907164572888,121.379723685801,38.906857634273,121.379784667030,38.906545115366,121.379832723203,38.906228714984,121.379871640465,38.905910127451,121.379937186653,38.905273176317,121.379971384273,38.904958207656,121.379985336355,38.904644761547,121.379945193317,38.904329348621,121.379867597113,38.904013816985,121.379770044053,38.903700106476,121.379670030449,38.903390159629,121.379585056206,38.903085918981,121.379532615839,38.902789326167,121.379530206555,38.902502321926,121.379595325565,38.902226850590,121.379745468280,38.901964851997,121.379989335640,38.901723906534,121.380288832365,38.901528536913,121.380626836261,38.901371306641,121.380991180400,38.901240491257,121.381369702351,38.901124365398,121.381750238784,38.901011201906,121.382122905249,38.900892644281,121.382499914541,38.900790206104,121.382883956530,38.900706172553,121.383273263152,38.900635738549,121.383666066337,38.900574098117,121.384257956041,38.900487621108,121.384651761071,38.900426950145,121.385042870833,38.900358259027,121.385429518159,38.900276742678,121.385810076175,38.900178142808,121.386185878576,38.900068809529,121.386557944295,38.899952415672,121.386926526939,38.899829527811,121.387291881916,38.899700717015,121.387654263734,38.899566551656,121.388013923305,38.899427602803,121.388371118733,38.899284437028,121.388726101829,38.899137625402,121.389079127101,38.898987737195,121.389430447258,38.898835341679,121.389780319507,38.898681006324,121.390128995658,38.898525302202,121.390474289458,38.898365553828,121.390808653797,38.898191901936,121.391134417021,38.898007552607,121.391454848164,38.897816952991,121.391773214463,38.897624551133,121.392092783156,38.897434794181,121.392416821480,38.897252132881,121.392748600269,38.897081010781,121.393091384960,38.896925877728,121.393448442792,38.896791181769,121.393822537381,38.896680362809,121.394207359083,38.896580728719,121.394594737558,38.896489446632,121.394995622051,38.896405393295,121.395396029005,38.896333166943,121.395798595230,38.896273551784,121.396201803571,38.896228284409,121.396604135973,38.896199103207,121.397004076178,38.896187746568,121.397400104332,38.896195950184,121.397790704179,38.896225453343,121.398174359460,38.896277993535,121.398549549423,38.896355307352,121.398914760509,38.896459133183,121.399268471964,38.896591208518,121.399608137806,38.896753371572,121.399909269498,38.896947949789,121.400168526957,38.897171146232,121.400394592238,38.897417395897,121.400596156389,38.897681130181,121.400781902364,38.897956783180,121.401049869757,38.898380432212,121.401234080589,38.898661525210,121.401432877526,38.898935051312,121.401654951616,38.899195443716,121.401908745693,38.899437289400,121.402178760842,38.899670264172,121.402452660163,38.899901278422,121.402732084919,38.900128153992,121.403018674573,38.900348713623,121.403314073087,38.900560779158,121.403619919924,38.900762169739,121.403937856348,38.900950711707,121.404269521822,38.901124223305,121.404616436201,38.901280567745,121.404975383508,38.901419681174,121.405343414868,38.901542873905,121.405719307201,38.901651128897,121.406101841028,38.901745432706,121.406489795069,38.901826770090,121.406881948045,38.901896125806,121.407277080474,38.901954485512,121.407673971977,38.902002809683,121.408071817661,38.902037896732,121.408470361219,38.902057652140,121.408869305875,38.902063021992,121.409268353952,38.902054955972,121.409667211374,38.902034401967,121.410065577765,38.902002306062,121.410463159948,38.901959617943,121.410859659347,38.901907286393,121.411254780085,38.901846257500,121.411648225386,38.901777478249,121.412039698474,38.901701899224,121.412428901674,38.901620467412,121.412815541805,38.901534129797,121.413200850940,38.901444410732,121.413586343536,38.901351716709,121.413970430492,38.901254400171,121.414351472344,38.901150787480,121.414727829627,38.901039205896,121.415097865575,38.900917980881,121.415459940725,38.900785440597,121.415812418310,38.900639908706,121.416153657966,38.900479715168,121.416482023827,38.900303185445,121.416953214620,38.900009803211,121.417262882677,38.899806641864,121.417555855719,38.899591802820,121.417817406449,38.899357717386,121.418032807569,38.899096814168,121.418173015473,38.898815315575,121.418226658235,38.898527671016,121.418211874280,38.898234556780,121.418146857792,38.897936615883,121.418049805655,38.897634483246,121.417938912052,38.897328800085,121.417832370269,38.897020204020,121.417748375388,38.896709336268,121.417705121595,38.896396836246,121.417710674909,38.896083226461,121.417726312320,38.895768647206,121.417748068719,38.895453820638,121.417778392960,38.895139557046,121.417819734794,38.894826666718,121.417874541278,38.894515959045,121.417945263065,38.894208242517,121.418034348108,38.893904327424,121.418144245262,38.893605024054,121.418277402481,38.893311139998,121.418434367453,38.893022303837,121.418597259857,38.892727972819,121.418764884493,38.892430540038,121.418942038345,38.892136398777,121.419133515700,38.891851945911,121.419344114440,38.891583575622,121.419578630650,38.891337680291,121.419841861314,38.891120657693,121.420138600717,38.890938899312,121.420473648541,38.890798802024,121.420849600230,38.890707689909,121.421233903923,38.890681474671,121.421615261436,38.890712664958,121.421994964197,38.890786555056,121.422374300934,38.890888439251,121.422754564872,38.891003611828,121.422939791939,38.891058701599,121.423137043841,38.891117367973,121.423523029265,38.891215001072,121.423910253956,38.891300090428,121.424290842549,38.891408856235,121.424666966009,38.891529671158,121.425041403239,38.891647913122,121.425416928649,38.891748961846,121.425792895627,38.891817572024,121.425796314849,38.891818196154,121.426182340743,38.891840994867,121.426574551276,38.891803571379,121.426941812815,38.891708307993,121.427105372516,38.891640061141,121.427281120728,38.891566727723,121.427599401592,38.891389550488,121.427903581986,38.891187493509,121.428200590286,38.890971274905,121.428497352172,38.890751612798,121.428800796021,38.890539227105,121.429117717110,38.890344621908,121.429444680928,38.890162185437,121.429775394920,38.889983212256,121.430273077042,38.889716404090,121.430602328736,38.889536404782,121.430757077778,38.889448475368,121.430824504448,38.889410164249,121.430926658440,38.889352120205,121.431243590320,38.889161336228,121.431550647645,38.888961840517,121.431845352782,38.888751418044,121.432003154123,38.888625367268,121.432125228098,38.888527855577,121.432384285008,38.888290421966,121.432524328336,38.888142699327,121.432620691593,38.888041052553,121.432838012765,38.887781557674,121.433039817035,38.887513752159,121.433229668415,38.887239449042,121.433411132719,38.886960460458,121.433763167837,38.886395683515,121.433940870276,38.886113520324,121.434124449785,38.885833925596,121.434317473973,38.885558711466,121.434523507755,38.885289690967,121.434740183214,38.885025446768,121.434949919504,38.884756626818,121.435156682636,38.884486053190,121.435366627569,38.884217756645,121.435585911961,38.883955771542,121.435820692572,38.883704129543,121.436077124361,38.883466863206,121.436361366785,38.883248014085,121.436677124151,38.883060672713,121.437019029306,38.882907424639,121.437379610682,38.882778335952,121.437751394912,38.882663473641,121.438126912228,38.882552904694,121.438498689264,38.882436696098,121.438859254452,38.882304913942,121.439201136224,38.882147627012,121.439518038428,38.881957284602,121.439815735609,38.881748428748,121.440097866424,38.881526963499,121.440366269089,38.881294737863,121.440622776421,38.881053598146,121.440869227534,38.880805392456,121.441107456145,38.880551968000,121.441339299570,38.880295172885,121.441563227162,38.880035336263,121.441766538696,38.879767250159,121.441950825971,38.879491467658,121.442119586451,38.879209358426,121.442276319398,38.878922295728,121.442424519577,38.878631651031,121.442567686251,38.878338796699,121.442709314185,38.878045105098,121.442852903540,38.877751946796,121.443001949981,38.877460695056,121.443159950972,38.877172720446,121.443330403077,38.876889397129,121.443516803759,38.876612095673,121.443810945020,38.876201002076,121.444008519778,38.875927118942,121.444208743040,38.875654359062,121.444412872957,38.875383566899,121.444622168579,38.875115582419,121.444837888059,38.874851246489,121.445061290447,38.874591403571,121.445293633895,38.874336894533,121.445536177454,38.874088560240,121.445790179274,38.873847243357,121.446056897509,38.873613785649,121.446334198965,38.873386868710,121.446617669771,38.873164268517,121.446908496131,38.872947719862,121.447207953285,38.872739023188,121.447517318271,38.872539975340,121.447837865426,38.872352374064,121.448170860998,38.872178030593,121.448515964142,38.872019059233,121.448871083934,38.871874480624,121.449234346189,38.871742041063,121.449603876719,38.871619480555,121.449977799537,38.871504545399,121.450354241356,38.871394977397,121.450732405377,38.871290501356,121.451114030889,38.871194981664,121.451498928134,38.871108215073,121.451886771558,38.871029737533,121.452277234708,38.870959090391,121.452669992927,38.870895809595,121.453064723359,38.870839436492,121.453461098652,38.870789507031,121.453858796847,38.870745563458,121.454257489693,38.870707141722,121.454656855231,38.870673782270,121.455056566109,38.870645022850,121.455456686178,38.870625931143,121.455857429478,38.870620110730,121.456659656219,38.870624976063,121.457060565893,38.870623940943,121.457460961155,38.870612781256,121.457860770959,38.870587191047,121.458261486380,38.870556572729,121.458662879889,38.870522917400,121.459064252714,38.870485331134,121.459464908780,38.870442920905,121.459864150211,38.870394791887,121.460261280934,38.870340048355,121.460655602175,38.870277798183,121.461046416960,38.870207144745,121.461433027413,38.870127195914,121.461814738361,38.870037055067,121.462190849229,38.869935830075,121.462560664844,38.869822625215,121.462923486431,38.869696546559,121.463278617915,38.869556700182,121.463625360523,38.869402191259,121.464137391329,38.869151872162,121.464476988823,38.868980237449,121.464806192853,38.868799083412,121.465116831278,38.868603015018,121.465400735557,38.868386636335,121.465649734449,38.868144555927,121.465848326340,38.867879892644,121.465852897594,38.867870774418,121.466175625606,38.866673798358,121.474376653061,38.866627982396,121.478362626435,38.868506430528,121.476942337020,38.873042193643,121.475705310553,38.874325036072,121.472177494996,38.875699509526,121.471948416088,38.878265194384,121.470894652567,38.879822930785,121.471213043149,38.882639572359,121.471319905091,38.882675704421,121.474526332625,38.894545286836,121.474942776289,38.898848536532,121.479593062671,38.898154464058,121.481675280091,38.899681423860,121.487227860778,38.898640314700,121.491322889541,38.902041270989,121.490767631022,38.904886968760,121.496181397754,38.904331710241,121.502566865769,38.907108001034,121.504024417694,38.903360008958,121.512006252488,38.903290601081,121.512557159187,38.915040364122,121.507736566390,38.923998444474,121.511086045486,38.924417881981,121.512556033235,38.924939336782,121.519302273282,38.925194772122,121.519437536714,38.925199893761,121.519523479526,38.925203147508,121.520088885994,38.927962066097,121.520997602359,38.927246542994,121.521712080449,38.930142058710,121.523064623934,38.935623420286,121.517930032846,38.936823874923,121.511305434199,38.939608429586,121.504572346738,38.939792249214,121.498377478339,38.939727719260,121.493086027499,38.944502931366,121.490698421896,38.942373444680,121.491408250491,38.938888830756,121.487600987697,38.939340540434,121.487490387273,38.939524873575,121.483535604186,38.946116178420,121.482953829157,38.949170500919,121.481128733305,38.949389433676,121.477840696792,38.951649825680,121.473075850271,38.950984963186,121.469751538704,38.951021900141,121.467461457381,38.950948026231,121.466722720978,38.950393974603,121.465060565194,38.949729112110,121.464084109195,38.950199096912,121.461866002415,38.949783201834,121.458446421167,38.951030887067";
HomePcs.jwszrq2 = "121.531472924437,38.935656192480,121.530255240588,38.934823448145,121.528900386745,38.934891643735,121.525452226840,38.935065203897,121.523064623934,38.935623420286,121.521712080449,38.930142058710,121.520997602359,38.927246542994,121.520088885994,38.927962066097,121.519523479526,38.925203147508,121.519437536714,38.925199893761,121.519302273282,38.925194772122,121.512556033235,38.924939336782,121.511086045486,38.924417881981,121.507736566390,38.923998444474,121.512557159187,38.915040364122,121.512006252488,38.903290601081,121.514613021075,38.903240418012,121.514789586771,38.903236494270,121.514791429482,38.903237283874,121.515688784711,38.903216512233,121.525136822008,38.903006555609,121.525319843037,38.903005290263,121.528233932451,38.904809251147,121.529517520418,38.904340914802,121.531321480403,38.902450225998,121.532466302079,38.901461516737,121.533021366344,38.901496208084,121.535796690366,38.900923797696,121.536525213169,38.902242076112,121.537479230183,38.902762449928,121.538277135682,38.903716466942,121.537860837709,38.904479681093,121.535085513687,38.906561173660,121.534807981105,38.907497845450,121.533541740160,38.908469209487,121.533538658184,38.908517588517,121.533170647508,38.909233339148,121.533121363761,38.909403482785,121.533071875867,38.909842681096,121.532898670938,38.910263322795,121.532651235068,38.910665406085,121.532484215675,38.910826239940,121.531871811536,38.911123162805,121.531649118713,38.911296368633,121.531605817256,38.911376785111,121.531890978787,38.911545410693,121.532341969907,38.911777410600,121.532453501129,38.911834679428,121.533529945552,38.912387409053,121.534171932889,38.912784407575,121.534489924172,38.913089404553,121.534895913217,38.913677399293,121.535090907820,38.913980395280,121.535373897488,38.914553389328,121.535578888956,38.915087382478,121.535742883029,38.915404379110,121.535909879938,38.915550378648,121.536246872996,38.915737377379,121.536679864185,38.915900378600,121.537044857635,38.916037378623,121.537344851685,38.916165378231,121.538168834825,38.916632376384,121.538400830235,38.916778375922,121.538774822301,38.917013374169,121.539568805857,38.917519371423,121.540221789205,38.918132367316,121.540851777788,38.918382367153,121.541091346390,38.918457560369,121.541450766741,38.918570367729,121.541496766164,38.918584369274,121.541951998487,38.918771582044,121.541940351367,38.918820913455,121.541925091671,38.918973498729,121.541848795886,38.919248152581,121.541803016797,38.919564767901,121.541719091164,38.919873753372,121.541635166431,38.920186553767,121.541543611849,38.920503168188,121.541444428319,38.920819783507,121.541352873737,38.921113509282,121.541268949004,38.921380535085,121.541040066147,38.921807773311,121.540773037647,38.922215938716,121.540506008247,38.922612659348,121.540269497341,38.923005565955,121.540193202455,38.923196298671,121.540195153984,38.923198574855,121.540202165998,38.923200184642,121.540214102700,38.923202925775,121.540716249057,38.923132708509,121.540931808457,38.923102565032,121.541219727310,38.923062303284,121.541843583416,38.922876916138,121.541855718867,38.922873309856,121.541882113969,38.922858259702,121.541969717829,38.922808311355,121.541988717806,38.922797311747,121.542367714599,38.922584317213,121.543405704011,38.922003330890,121.543923699120,38.921713338201,121.543986477195,38.921682717185,121.543992755362,38.921679655892,121.549168201752,38.919622897380,121.549798829753,38.921608119320,121.549008396721,38.924512961905,121.548842596809,38.924701325806,121.548519599901,38.924899320548,121.547005601129,38.925368496860,121.546854465562,38.925323156639,121.545826901991,38.925659090296,121.546330913542,38.925509646354,121.546382906047,38.925707217515,121.546174936026,38.926570293285,121.546382906047,38.927183805389,121.546757252446,38.927308588122,121.547192333660,38.927256386974,121.547505945244,38.927464565638,121.547767393452,38.927564995629,121.547474749561,38.929294703089,121.547412358195,38.929929012015,121.547069207479,38.930480132753,121.545935770321,38.931072847135,121.545280664572,38.932403856354,121.543340287325,38.933302709853,121.541201829902,38.932705004233,121.541148049544,38.932689972065,121.541140910726,38.932680564258,121.541115527361,38.932688219287,121.534480806845,38.934689027378,121.531472924437,38.935656192480";
HomePcs.orgcodes = "";
function getParm(name){
	  var flag = ""; 
	  var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
	  	  var r = window.location.search.substr(1).match(reg);
	  	  if(r != null){
	  		  flag = unescape(r[2]);
	  	  } 
	  	  return flag;
	}
  
/**
 * @title:Jquery
 * @description:初始化派出所主页面
 * @author: zhang_guoliang@founder.com
 * @param  
 * @date:2014-10-22 17:52:45
 */
$(function(){
	HomePcs.orgcodes = getParm("orgcodes");
	HomePcs.zzjgdm = userOrgCode;
	if(typeof EzServerClient != "undefined"){
	  HomePcs.onloadMap();
	}
});
/**
 * @title:onloadMap
 * @description:初始化派出苏首页地图
 * @author: zhang_guoliang@founder.com
 * @param  
 * @date:2014-10-22 17:54:32
 */
HomePcs.onloadMap = function(){
	/*地图对象*/
	HomePcs.map = new FrameTools.Map();
	/*设置地图代理*/
	HomePcs.map.setProxy(contextPath + "/Proxy");
	/*设置地图加载容器*/
	HomePcs.map.setMapDiv("mapDiv");
	/*加载地图*/
	HomePcs.map.onloadMap();
	/*显示鹰眼*/
	HomePcs.map.addOverView();
	/*隐藏自带矢量影像图层对象*/
	HomePcs.map._MapApp.hideMapServer();
	/*加载自定义的矢量影像图层对象*/
	HomePcs.map.showNewMapServer("mapDiv","HomePcs.map");
	/*加载地图工具条*/
	HomePcs.map.buildTools("mapDiv","toolDiv","HomePcs.map");
	/*设置工具条显示的位置*/
	HomePcs.diyToolDiv();
	/*窗口变化地图工具条自动变*/
	$("#mapDiv").resize(function(){HomePcs.diyToolDiv();});
	if(bjzbz!="" && bjzbz!='null'){
		/*显示当前用户边界*/
		HomePcs.moveMapToBjzbz("0");
	}
};
/**
 * @title:diyToolDiv
 * @description:设置工具条显示的位置
 * @author: zhang_guoliang@founder.com
 * @param  
 * @param   
 * @date:2014-10-22 17:55:43
 */	
HomePcs.diyToolDiv =function(){
	var left = $("#mapDiv").offset().left-230;
	var top = $("#mapDiv").height() - 40;
	$("#toolDiv").css({
		"top" : top,
		"left" : left
	});
};
/**
 * @title:moveMapToBjzbz
 * @description:显示当前用户边界
 * @author: zhang_guoliang@founder.com
 * @param  
 * @date:2014-10-22 17:56:12
 */	
HomePcs.moveMapToBjzbz = function(bs){
	/*清楚地图上所有的标记*/
	HomePcs.map._MapApp.clear();
	/*非地坐标*/
	var bj = bjzbz.split(";");
	var bjnum = bj.length;
	/*计算辖区面积*/
	HomePcs.showAreaMJ(14,bjzbz);
	/*记录边线中心点坐标*/
	HomePcs.mbrArr = new Array();
	for(var j=0;j<bjnum;j++){
		var gArr = bj[j];
		/*创建边界图元素*/
		var polyline = HomePcs.map.initPolyline(gArr,"blue");
		/*图元素添加到地图上*/
		if(polyline){
			if(bs=="1"){
				HomePcs.map._MapApp.addOverlay(polyline);
			}
			HomePcs.mbrArr.push(polyline);
			if(HomePcs.Mbr==null){
				HomePcs.Mbr = polyline.getMBR();
			}else{
				HomePcs.Mbr = MBR.union(HomePcs.Mbr,polyline.getMBR());
			}
		}
	}
	if(HomePcs.eqkg == "1"){
		HomePcs.EventListenerZoom = HomePcs.map._MapApp.addMapEventListener(EzEvent.MAP_ZOOMCHANGE,HomePage.hottest);
		HomePcs.EventListenerPan = HomePcs.map._MapApp.addMapEventListener(EzEvent.MAP_PAN,HomePage.hottest);
	}
	if(bs=="0"){
		/*根据图元素将地图放到最适合的级别和位置*/
		HomePcs.map._MapApp.centerAtMBR(HomePcs.Mbr);
		if(userOrgCode!="210204410000"||screen.width>1600){
			/*新版本cliect自动适应级别有问题必须降一级*/
			HomePcs.map._MapApp.zoomOut();
		}
		/*各个辖区组织机构*/
		HomePcs.queryXjZzjg();
	}
};
/**
 * @title:queryXjZzjg
 * @description:加载派出所全部责任区信息
 * @author: zhang_guoliang@founder.com
 * @param  
 * @date:2014-10-22 17:56:12
 */	
HomePcs.queryXjZzjg = function(){
	//var params = {zzjgdm:userOrgCode};
	if(HomePcs.orgcodes!=''){
		var params = {zzjgdm: HomePcs.orgcodes};
		//var fajax =new FrameTools.Ajax(contextPath+"/xj/queryXjZzjg",HomePcs.queryXjZzjg_back);
		var fajax =new FrameTools.Ajax(contextPath+"/xj/queryXjZzjgxj",HomePcs.queryXjZzjg_back);
		fajax.send(params);
	}
};
/**
 * @title:queryXjZzjg_back
 * @description:加载派出所全部责任区信息_回调函数
 * @author: zhang_guoliang@founder.com
 * @param  
 * @date:2014-10-23 14:17:48
 */	
HomePcs.queryXjZzjg_back = function(json){
	if(json[0].bjzbz!=""){
		HomePcs.map._MapApp.clear();
	}
	if(json!=null&&json.length>0){
		HomePcs.bjJson = json;
		HomePcs.countZrq = json.length;
		var colors = new Array("#F1E740","#FFB543","#FF7A7B","#008080","#AA4400","#0000FF","#0066CC","#00CCCC","#6600CC","#FF99FF","#CCFFFF","#85D021","#4DC2ED","#EE431B","#E96A3B","#EE9539","#FDBE63","#FFFF66","#CC3333","#9966FF","#99CCFF","#FF00FF","#FF66CC","#996666","#00CC00","#330000","#336600","#666600","#990000","#996600","#99CC00","#CC0000","#CC6600","#CCCC00");
		//辖区面
        for(var i=0;i<HomePcs.countZrq;i++){
        	if(json[i].bjzbz!=""&&json[i].bjzbz!=null){
        		var col = colors[i];
        		HomePcs.showArea(json[i].zzjgdm,json[i].zzjgmc,json[i].bjzbz,col);
        	}
        }
	}
	//加载派出所概况
	if(HomePcs.PcsTjJson!=""){
		HomePcs.initFloatWin_back(HomePcs.PcsTjJson);
	}else{
		HomePcs.initFloatWin(userOrgCode);
	}
	if(userOrgCode=="210211570000"){
		/*警务室1*/
		var polyline1 = HomePcs.map.initPolyline(HomePcs.jwszrq1,"blue",5);
		HomePcs.map._MapApp.addOverlay(polyline1);
		/*警务室2*/
		var polyline2 = HomePcs.map.initPolyline(HomePcs.jwszrq2,"#008000",5);
		HomePcs.map._MapApp.addOverlay(polyline2);
		/*基站1*/
		var initMarker1 = HomePcs.map.initMarker("",121.46726,38.91204,"jz.png",null,null,32,54);
		HomePcs.map._MapApp.addOverlay(initMarker1);
		/*基站2*/
		var initMarker2 = HomePcs.map.initMarker("",121.42358,38.9219,"jz.png",null,null,32,54);
		HomePcs.map._MapApp.addOverlay(initMarker2);
	}
};
/**
 * @title:showArea
 * @description:各个辖区面
 * @author: zhang_guoliang@founder.com
 * @param  begin
 * @date:2014-10-23 14:17:48
 */	
HomePcs.showArea = function(dm,mc,zbz,col){
	var ObjMap = new Polygon(zbz, "red", 3, 0.4,col);
	var pMbr = ObjMap.getMBR();
	var cPoint = pMbr.centerPoint();
	var _pTitle = new Title(mc,12,7,"宋体","#000000","#FFFFFF","#FFFFFF","2");
	_pTitle.setPoint(cPoint);
	HomePcs.map._MapApp.addOverlay(ObjMap);
	HomePcs.map._MapApp.addOverlay(_pTitle);
	//点击下钻到责任区
	_pTitle.addListener("click", function (){
		HomePcs.map._MapApp.clear();
		/*加载本责任区*/
		HomePcs.showArea(dm,mc,zbz,col);
		/*根据图元素将地图放到最适合的级别和位置*/
		HomePcs.map._MapApp.centerAtMBR(pMbr);
		if(userOrgCode!="210204410000"||screen.width>1600){
			/*新版本cliect自动适应级别有问题必须降一级*/
			HomePcs.map._MapApp.zoomOut();
		}
		/*记录当前展示的组织机构代码*/
		HomePcs.zzjgdm = dm;
		/*记录当前展示的组织机构名称*/
		HomePcs.zzjgmc = mc;
		/*计算辖区面积*/
		HomePcs.showAreaMJ(15,zbz);
		/*获取责任区民警*/
		HomePcs.queryZrqUser();
	});	
	/*记录当前展示的组织机构代码*/
	HomePcs.zzjgdm = userOrgCode;
	/*记录当前展示的组织机构名称*/
	HomePcs.zzjgmc = "";
};
/**
 * @title:queryZrqUser
 * @description:获取责任区民警
 * @author: zhang_guoliang@founder.com
 * @param  
 * @date:2014-10-26 14:36:42
 */	
HomePcs.queryZrqUser = function(){
	var params = {zzjgdm:HomePcs.zzjgdm};
	var fajax =new FrameTools.Ajax(contextPath+"/xj/queryZrqUser",HomePcs.queryZrqUser_back);
	fajax.send(params);
};
/**
 * @title:queryZrqUser_back
 * @description:获取责任区民警_回调函数
 * @author: zhang_guoliang@founder.com
 * @param  
 * @date:2014-10-26 14:42:21
 */	
HomePcs.queryZrqUser_back = function(json){
	HomePcs.queryHTML = "<div class='textwrap'><div class='oneText'>1</div><div class='title_big'>责任区信息</div></div>";
	if(json!=null&&json.length>0){
		for(var i=0;i<json.length;i++){
			var username = json[i].username;
			var telephone = json[i].telephone;
			HomePcs.queryHTML += "<div class='text1'>姓名：<span class='bold'>"+username+"</span> 电话：<span class='bold'>"+telephone+"</span></div>";
		}
	}
	HomePcs.queryHTML += "<div class='text1'>辖区面积：<span class='redText'>"+HomePcs.XqMJ+"</span>(平方米)</div>";
	/*责任区概况*/
	HomePcs.initFloatWin(HomePcs.zzjgdm);
	//组织机构名称
	$jquery("#orgZzjgmc").html(HomePcs.zzjgmc); 
};
/**
 * @title:initFloatWin
 * @description:辖区概况统计查询
 * @author: zhang_guoliang@founder.com
 * @param  
 * @date:2014-10-23 14:17:48
 */	
HomePcs.initFloatWin = function(zzjgdm){
	var params = {zzjgdm:zzjgdm};
	var fajax =new FrameTools.Ajax(contextPath+"/xj/queryPcsTj",HomePcs.initFloatWin_back);
	fajax.send(params);
};
/**
 * @title:initFloatWin_back
 * @description:辖区概况文字描述_回调函数
 * @author: zhang_guoliang@founder.com
 * @param  
 * @date:2014-10-23 16:30:23
 */	
HomePcs.initFloatWin_back = function(json){
	var czrkNum = 0,jzrkNum = 0,ldrkNum = 0,jwrkNum = 0,wlhrkNum = 0,zdrkNum = 0,jkdxNum = 0,jsbrNum = 0,fzcfNum = 0,qtgzdxNum = 0;
	var bzdzyhsNum = 0,bzdzwhsNum = 0,twNum = 0;
	var dwldNum = 0,dwwbNum=0,dwzsNum=0;
	var fwzsNum = 0,fwczfwNum=0,fwkzfNum=0,fwsyNum=0;
	var aqbnNum=0,aqbyNum=0,aqbzNum=0;
	var jqbnNum=0,jqbyNum=0,jqwpNum=0;
	var zdrkNum=0,zdflgNum=0;zdxdryNum=0;zdsfryNum=0;zdqtNum=0;
	if(json!=null&&json.length>0){
		 if(HomePcs.PcsTjJson == ""){
			 HomePcs.PcsTjJson = json;
		 }
		 for(var i=0;i<json.length;i++){
			 if(json[i].lxmc=="常住人员"){
				 czrkNum = json[i].sl;
			 }else if(json[i].lxmc=="寄住人员"){
				 jzrkNum = json[i].sl;
			 }else if(json[i].lxmc=="暂住人口"){
				 ldrkNum = json[i].sl;
			 }else if(json[i].lxmc=="境外人员"){
				 jwrkNum = json[i].sl;
			 }else if(json[i].lxmc=="未落户人员"){
				 wlhrkNum = json[i].sl;
			 }else if(json[i].lxmc=="重口"){
				 zdrkNum = json[i].sl;
			 }else if(json[i].lxmc=="监管对象"){
				 jkdxNum = json[i].sl;
			 }else if(json[i].lxmc=="精神病人"){
				 jsbrNum = json[i].sl;
			 }else if(json[i].lxmc=="非正常访"){
				 fzcfNum = json[i].sl;
			 }else if(json[i].lxmc=="其它工作对象"){
				 qtgzdxNum = json[i].sl;
			 }else if(json[i].lxmc=="已核实"){
				 bzdzyhsNum = json[i].sl;
			 }else if(json[i].lxmc=="未核实"){
				 bzdzwhsNum = json[i].sl;
			 }else if(json[i].lxmc=="天网"){
				 twNum = json[i].sl;
			 }else if(json[i].lxmc=="全部单位"){
				 dwzsNum = json[i].sl;
			 }else if(json[i].lxmc=="宾馆旅店"){
				 dwldNum = json[i].sl;
			 }else if(json[i].lxmc=="上网服务场所"){
				 dwwbNum = json[i].sl;
			 }else if(json[i].lxmc=="所有房屋"){
				 fwzsNum = json[i].sl;
			 }else if(json[i].lxmc=="出租房屋"){
				 fwczfwNum = json[i].sl;
			 }else if(json[i].lxmc=="有人居住房屋"){
				 fwsyNum = json[i].sl;
			 }else if(json[i].lxmc=="本周发生"){
				 aqbzNum = json[i].sl;
			 }else if(json[i].lxmc=="本月发生"){
				 aqbyNum = json[i].sl;
			 }else if(json[i].lxmc=="本年发生"){
				 aqbnNum = json[i].sl;
			 }else if(json[i].lxmc=="本年刑事案件发生"){
				 jqbnNum = json[i].sl;
			 }else if(json[i].lxmc=="本年未破刑事案件"){
				 jqwpNum = json[i].sl;
			 }else if(json[i].lxmc=="本月刑事案件发生"){
				 jqbyNum = json[i].sl;
			 }else if(json[i].lxmc=="重点人口总计"){
				 zdrkNum = json[i].sl;
			 }else if(json[i].lxmc=="法轮功"){
				 zdflgNum = json[i].sl;
			 }else if(json[i].lxmc=="吸毒人员"){
				 zdxdryNum = json[i].sl;
			 }else if(json[i].lxmc=="上访人员"){
				 zdsfryNum = json[i].sl;
			 }
		 }
	}
	var syrkNum = parseFloat(czrkNum)+parseFloat(jzrkNum)+parseFloat(ldrkNum)+parseFloat(jwrkNum)+parseFloat(wlhrkNum);
	var gzdxNum = parseFloat(zdrkNum)+parseFloat(jkdxNum)+parseFloat(jsbrNum)+parseFloat(fzcfNum)+parseFloat(qtgzdxNum);
	var bzdzNum = parseFloat(bzdzyhsNum)+parseFloat(bzdzwhsNum);
	var fwkzfNum = parseFloat(fwzsNum)-parseFloat(fwsyNum);
	zdqtNum = parseFloat(zdrkNum)-parseFloat(zdflgNum)-parseFloat(jkdxNum)-parseFloat(zdxdryNum)-parseFloat(zdsfryNum);
	//加载树状数字
	//实有人口
	if(syrkNum==0){
		$jquery("#syrkNumId").html("（<span style='font-weight: bold;'>"+syrkNum+"</span>）"); 
	}else{
		$jquery("#syrkNumId").html("（<span style='font-weight: bold;'>"+syrkNum+"</span>）<span style='color: blue;font-weight: bold;' onclick='HomePage.hottest()'>【热度分析】</span>"); 
	}
	if(czrkNum==0){
		$jquery("#czrkNumId").html("（<span style='font-weight: bold;'>"+czrkNum+"</span>）"); 
	}else{
		$jquery("#czrkNumId").html("（<span style='color: blue;font-weight: bold;' onclick='HomePage.syrkListMBR(1)'>"+czrkNum+"</span>）"); 
	}
	if(jzrkNum==0){
		$jquery("#jzrkNumId").html("（<span style='font-weight: bold;'>"+jzrkNum+"</span>）"); 
	}else{
		$jquery("#jzrkNumId").html("（<span style='color: blue;font-weight: bold;' onclick='HomePage.syrkListMBR(2)'>"+jzrkNum+"</span>）"); 
	}
	if(ldrkNum==0){
		$jquery("#ldrkNumId").html("（<span style='font-weight: bold;'>"+ldrkNum+"</span>）"); 
	}else{
		$jquery("#ldrkNumId").html("（<span style='color: blue;font-weight: bold;' onclick='HomePage.syrkListMBR(3)'>"+ldrkNum+"</span>）"); 
	}
	if(jwrkNum==0){
		$jquery("#jwrkNumId").html("（<span style='font-weight: bold;'>"+jwrkNum+"</span>）"); 
	}else{
		$jquery("#jwrkNumId").html("（<span style='color: blue;font-weight: bold;' onclick='HomePage.syrkListMBR(4)'>"+jwrkNum+"</span>）"); 
	}
	if(wlhrkNum==0){
		$jquery("#wlhrkNumId").html("（<span style='font-weight: bold;'>"+wlhrkNum+"</span>）"); 
	}else{
		$jquery("#wlhrkNumId").html("（<span style='color: blue;font-weight: bold;' onclick='HomePage.syrkListMBR(5)'>"+wlhrkNum+"</span>）"); 
	}
	//重点人员
	if(zdrkNum==0){
		$jquery("#zdrkNumId").html("（<span style='font-weight: bold;'>"+zdrkNum+"</span>）");
	}else{
		$jquery("#zdrkNumId").html("（<span style='color: blue;font-weight: bold;' onclick='HomePcs.zdryListMBR(2)'>"+zdrkNum+"</span>）"); 
	}
	if(zdflgNum==0){
		$jquery("#flgNumId").html("（<span style='font-weight: bold;'>"+zdflgNum+"</span>）");
	}else{
		$jquery("#flgNumId").html("（<span style='color: blue;font-weight: bold;' onclick='HomePcs.zdryListMBR(11)'>"+zdflgNum+"</span>）"); 
	}
	if(jkdxNum==0){
		$jquery("#jgdxNumId").html("（<span style='font-weight: bold;'>"+jkdxNum+"</span>）");
	}else{
		$jquery("#jgdxNumId").html("（<span style='color: blue;font-weight: bold;' onclick='HomePcs.zdryListMBR(12)'>"+jkdxNum+"</span>）"); 
	}
	if(zdxdryNum==0){
		$jquery("#xdryNumId").html("（<span style='font-weight: bold;'>"+zdxdryNum+"</span>）");
	}else{
		$jquery("#xdryNumId").html("（<span style='color: blue;font-weight: bold;' onclick='HomePcs.zdryListMBR(13)'>"+zdxdryNum+"</span>）"); 
	}
	if(zdsfryNum==0){
		$jquery("#sfryNumId").html("（<span style='font-weight: bold;'>"+zdsfryNum+"</span>）");
	}else{
		$jquery("#sfryNumId").html("（<span style='color: blue;font-weight: bold;' onclick='HomePcs.zdryListMBR(3)'>"+zdsfryNum+"</span>）"); 
	}
	if(zdqtNum==0){
		$jquery("#qtgzdxNumId").html("（<span style='font-weight: bold;'>"+zdqtNum+"</span>）");
	}else{
		$jquery("#qtgzdxNumId").html("（<span style='color: blue;font-weight: bold;' onclick='HomePcs.zdryListMBR(4)'>"+zdqtNum+"</span>）"); 
	}
	//单位
	if(dwzsNum==0){
		$jquery("#dwzsNumId").html("（<span style='font-weight: bold;'>"+dwzsNum+"</span>）"); 
	}else{
		$jquery("#dwzsNumId").html("（<span style='color: blue;font-weight: bold;' onclick='HomePcs.sydwListMap()'>"+dwzsNum+"</span>）"); 
	}
	if(dwldNum==0){
		$jquery("#dwldNumId").html("（<span style='font-weight: bold;'>"+dwldNum+"</span>）"); 
	}else{
		$jquery("#dwldNumId").html("（<span style='color: blue;font-weight: bold;' onclick='HomePcs.sydwListMap(211)'>"+dwldNum+"</span>）"); 
	}
	if(dwwbNum==0){
		$jquery("#dwwbNumId").html("（<span style='font-weight: bold;'>"+dwwbNum+"</span>）");
	}else{
		$jquery("#dwwbNumId").html("（<span style='color: blue;font-weight: bold;' onclick='HomePcs.sydwListMap(350)'>"+dwwbNum+"</span>）");
	}
	//实有房屋
	if(fwzsNum==0){
		$jquery("#fwzsNumId").html("（<span style='font-weight: bold;'>"+fwzsNum+"</span>）"); 
	}else{
		$jquery("#fwzsNumId").html("（<span style='color: blue;font-weight: bold;' onclick='HomePcs.syfwListMap(1)'>"+fwzsNum+"</span>）"); 
	}
	if(fwczfwNum==0){
		$jquery("#fwczfNumId").html("（<span style='font-weight: bold;'>"+fwczfwNum+"</span>）"); 
	}else{
		$jquery("#fwczfNumId").html("（<span style='color: blue;font-weight: bold;' onclick='HomePcs.syfwListMap(2)'>"+fwczfwNum+"</span>）"); 
	}
	if(fwkzfNum==0){
		$jquery("#fwkzfNumId").html("（<span style='font-weight: bold;'>"+fwkzfNum+"</span>）");
	}else{
		$jquery("#fwkzfNumId").html("（<span style='color: blue;font-weight: bold;'>"+fwkzfNum+"</span>）");
	}
	//案情
	$jquery("#aqbnNumId").html(aqbnNum); 
	$jquery("#aqbyNumId").html(aqbyNum); 
	$jquery("#aqbzNumId").html(aqbzNum);
	//警情
	$jquery("#jqbzNumId").html(jqbnNum); 
	$jquery("#jqbyNumId").html(jqbyNum); 
	$jquery("#jqwpNumId").html(jqwpNum);
	//天网
	$jquery("#twNumId").html(twNum); 
	//350M和巡逻车
	if(userOrgCode=="210211570000"){
		$jquery("#gpsNumId").html("（<span style='color: blue;font-weight: bold;' onclick='HomePcs.openXlc()'>22</span>）<a herf='#' onclick='HomePcs.jwtsOpen()'>详情</a>");
	}else if(userOrgCode=="210204410000"){
		$jquery("#gpsNumId").html("（<span style='color: blue;font-weight: bold;' onclick='HomePcs.openXlc()'>19</span>）<a herf='#' onclick='HomePcs.jwtsOpen()'>详情</a>");
	}else{
		$jquery("#gpsNumId").html("（<span style='font-weight: bold;'>0</span>）");
	}
	//加载页面显示数据
	if(HomePcs.zzjgdm!=""&&HomePcs.zzjgdm.substring(10, 12)!="00"){
	}else{
		if(userOrgCode=="210211570000"){
			 HomePcs.queryHTML = "<div class='textwrap'><div class='oneText'>1</div><div class='title_big'>基本信息</div></div>" +
		 		"<div class='text1'>共有<span class='bold'>"+HomePcs.countZrq+"</span>个责任区，面积<span class='redText'>85</span>(平方公里)</div>";
		}else{
			 HomePcs.queryHTML = "<div class='textwrap'><div class='oneText'>1</div><div class='title_big'>基本信息</div></div>" +
		 		"<div class='text1'>共有<span class='bold'>"+HomePcs.countZrq+"</span>个责任区，面积<span class='redText'>"+HomePcs.PcsXqMJ+"</span>(平方公里)</div>";
		}
	}
	HomePcs.queryHTML += "<div class='textwrap'><div class='oneText'>2</div><div class='title_big'>实有人口</div></div>" +
			"<div class='text1'>实有人口<span class='blueText' onclick='HomePcs.initFalsh(1);'>"+syrkNum+"</span>人，其中" +
			"常住人口<span class='bold'>"+czrkNum+"</span>人、" +
			"寄住人口<span class='bold'>"+jzrkNum+"</span>人、" +
			"流动人口<span class='blueText' onclick='HomePcs.initFalsh(4);'>"+ldrkNum+"</span>人、" +
			"境外人口<span class='bold'>"+jwrkNum+"</span>人、" +
			"未落户人口<span class='bold'>"+wlhrkNum+"</span>人。</div>" +
			
			"<div class='textwrap'><div class='oneText'>3</div><div class='title_big'>重点人员</div></div>" +
			"<div class='text1'>重点人员<span class='bold'>"+zdrkNum+"</span>个，其中" +
			"法轮功<span class='bold'>"+zdflgNum+"</span>个、" +
			"监管对象<span class='bold'>"+jkdxNum+"</span>个、" +
			"吸毒人员<span class='bold'>"+zdxdryNum+"</span>个、" +
		    "上访人员<span class='bold'>"+zdsfryNum+"</span>个、" +
		    "其他<span class='bold'>"+zdqtNum+"</span>个。</div>" +
		    "<div class='textwrap'><div class='oneText'>4</div><div class='title_big'>实有单位</div></div>" +
			"<div class='text1'>实有单位<span class='bold'>"+dwzsNum+"</span>个，其中" +
			"旅店<span class='bold'>"+dwldNum+"</span>个、" +
		    "网吧<span class='bold'>"+dwwbNum+"</span>个。</div>" +
			"<div class='textwrap'><div class='oneText'>5</div><div class='title_big'>标准地址</div></div>" +
			"<div class='text1'>标准地址<span class='bold'>"+bzdzNum+"</span>条，其中" +
			"已核实<span class='bold'>"+bzdzyhsNum+"</span>条、" +
			"未核实<span class='bold'>"+bzdzwhsNum+"</span>条。</div>";
		 HomePcs.queryHTML += "<br><div class='text2'>" +
	 		"<a id='backBotton' class='l-btn l-btn-small' href='javascript:void(0)' group='' onclick='HomePcs.back()'>" +
	 		"<span class='l-btn-left l-btn-icon-left'><span class='l-btn-text'>后退</span>" +
	 		"<span class='l-btn-icon icon-back'></span>" +
	 		"</span></a></div>";
	 if(HomePcs.floatWin!=""){
		 HomePcs.floatWin.close();
	 }
	 var titleWin = userOrgName+"辖区概况";
	 if(HomePcs.zzjgmc!=""){
		 titleWin = HomePcs.zzjgmc+"辖区概况";
		 $jquery("#OrgZzjgmc").html(HomePcs.zzjgmc);
	 }
	 /*加载辖区概况窗口*/
	 var left = $jquery("#mapDiv").width() - 290;
	 HomePcs.floatWin = new FrameTools.FloatWin(titleWin,"mapDiv",280,550,85,left,85,null,220,0.9);
	 HomePcs.floatWin.setOpHtml(HomePcs.queryHTML);
	 HomePcs.queryHTML = "";
};
/**
 * @title:jwtsOpen
 * @description:打开警务态势系统
 * @author: zhang_guoliang@founder.com
 * @param  
 * @date:2014-11-01 15:07:32
 */	
HomePcs.jwtsOpen = function(){
	var url = "";
	if(userOrgCode=="210211570000"){
		url = "http://10.80.8.178:9080/Component_hq/";
	}else if(userOrgCode=="210204410000"){
		url = "http://10.80.8.178:9080/Component_bsl/";
	}
	window.open(url,"警务态势系统");
};
/**
 * @title:zdryListMBR
 * @description:重点人口撒点
 * @author: zhang_guoliang@founder.com
 * @param  
 * @date:2014-10-29 18:07:12
 */	
HomePcs.zdryListMBR = function(lx){
	HomePcs.removeMap();
	$(document.getElementById("tdmapid")).mask("数据加载中...");
	var params = {lx:lx,zzjgdm:HomePcs.zzjgdm};
	var fajax =new FrameTools.Ajax(contextPath+"/xj/queryZdrkMap",HomePcs.zdryListMBR_back);
	fajax.send(params);
};
/**
 * @title:zdryListMBR_back
 * @description:重点人口撒点_回调函数
 * @author: zhang_guoliang@founder.com
 * @param  
 * @date:2014-10-29 18:07:32
 */	
HomePcs.zdryListMBR_back = function(json){
	//关闭所有器已经打开的气泡框
	HomePcs.map._MapApp.closeInfoWindow();
	//清空已存在坐标点
	if(HomePcs.mpdzMarkerArr != null){
		var markerLen = HomePcs.mpdzMarkerArr.length;
		for(var j=0;j<markerLen;j++){
			HomePcs.map._MapApp.removeOverlay(HomePcs.mpdzMarkerArr[j]);
		}
	}
	//加载坐标点以及气泡框
	var listLen = json.length;
	for(var i=0;i<listLen;i++){
		HomePcs.zdryListMBRRyxq(json[i].mc,json[i].zbx,json[i].zby,json[i].ryid,json[i].zdryid,json[i].jzdzdm);
	}
	$(document.getElementById("tdmapid")).unmask();
};
/**
 * @title:zdryListMBRRyxq
 * @description:重点人员撒点
 * @author: zhang_guoliang@founder.com
 * @param  
 * @date:2014-10-29 13:44:35
 */	
HomePcs.zdryListMBRRyxq = function(mc,zbx,zby,ryid,zdryid,jzdzdm){
	var initMarker = HomePcs.map.initMarker(mc,zbx,zby,"location.png",null,null,28,28);
	HomePcs.map._MapApp.addOverlay(initMarker);
	HomePcs.mpdzMarkerArr.push(initMarker);
	initMarker.addListener("click", function(){
		 var editUrl = "/syrkgl/view?id="+ryid+"&jzdzdm="+jzdzdm+"&zdryid="+zdryid;
	     menu_open("实有人口－" + mc,editUrl);
	});
};
/**
 * @title:syfwListMap
 * @description:实有房屋撒点
 * @author: zhang_guoliang@founder.com
 * @param  
 * @date:2014-10-29 13:44:35
 */	
HomePcs.syfwListMap = function(lx){
	HomePcs.removeMap();
	$(document.getElementById("tdmapid")).mask("数据加载中...");
	var params = {lx:lx,zzjgdm:HomePcs.zzjgdm};
	var fajax =new FrameTools.Ajax(contextPath+"/xj/querySyfwMap",HomePcs.syfwListMap_back);
	fajax.send(params);
};
/**
 * @title:syfwListMap_back
 * @description:实有房屋撒点_回调函数
 * @author: zhang_guoliang@founder.com
 * @param  
 * @date:2014-10-29 13:48:24
 */	
HomePcs.syfwListMap_back = function(json){
	//关闭所有器已经打开的气泡框
	HomePcs.map._MapApp.closeInfoWindow();
	//清空已存在坐标点
	if(HomePcs.mpdzMarkerArr != null){
		var markerLen = HomePcs.mpdzMarkerArr.length;
		for(var j=0;j<markerLen;j++){
			HomePcs.map._MapApp.removeOverlay(HomePcs.mpdzMarkerArr[j]);
		}
	}
	//加载坐标点以及气泡框
	var listLen = json.length;
	for(var i=0;i<listLen;i++){
		HomePcs.syfwListMBRRyxq(json[i].mc,json[i].zbx,json[i].zby,json[i].id);
	}
	$(document.getElementById("tdmapid")).unmask();
};
/**
 * @title:syfwListMBRRyxq
 * @description:实有房屋撒点
 * @author: zhang_guoliang@founder.com
 * @param  
 * @date:2014-10-30 17:55:53
 */	
HomePcs.syfwListMBRRyxq = function(mc,zbx,zby,id){
	var initMarker = HomePcs.map.initMarker(mc,zbx,zby,"location.png",null,null,28,28);
	HomePcs.map._MapApp.addOverlay(initMarker);
	HomePcs.mpdzMarkerArr.push(initMarker);
	initMarker.addListener("click", function(){
	     var hsUrl = "/forward/sqjw|building|buildingShow?bzdzid="+id+"&bs=3";
	     menu_open("层户结构",hsUrl);
	});
};
/**
 * @title:sydwListMap
 * @description:实有单位撒点
 * @author: zhang_guoliang@founder.com
 * @param  
 * @date:2014-10-28 21:39:15
 */	
HomePcs.sydwListMap = function(lx){
	HomePcs.removeMap();
	$(document.getElementById("tdmapid")).mask("数据加载中...");
	var params = {lx:lx,zzjgdm:HomePcs.zzjgdm};
	var fajax =new FrameTools.Ajax(contextPath+"/xj/querySydwMap",HomePcs.sydwListMap_back);
	fajax.send(params);
};
/**
 * @title:sydwListMap_back
 * @description:实有单位撒点_回调函数
 * @author: zhang_guoliang@founder.com
 * @param  
 * @date:2014-10-28 21:41:32
 */	
HomePcs.sydwListMap_back = function(json){
	//关闭所有器已经打开的气泡框
	HomePcs.map._MapApp.closeInfoWindow();
	//清空已存在坐标点
	if(HomePcs.mpdzMarkerArr != null){
		var markerLen = HomePcs.mpdzMarkerArr.length;
		for(var j=0;j<markerLen;j++){
			HomePcs.map._MapApp.removeOverlay(HomePcs.mpdzMarkerArr[j]);
		}
	}
	//加载坐标点以及气泡框
	var listLen = json.length;
	for(var i=0;i<listLen;i++){
		HomePcs.sydwListMBRRyxq(json[i].mc,json[i].zbx,json[i].zby,json[i].id);
	}
	$(document.getElementById("tdmapid")).unmask();
};
/**
 * @title:sydwListMBRRyxq
 * @description:实有单位详情页面
 * @author: zhang_guoliang@founder.com
 * @param  
 * @date:2014-10-30 16:34:22
 */	
HomePcs.sydwListMBRRyxq = function(mc,zbx,zby,id){
	var initMarker = HomePcs.map.initMarker(mc,zbx,zby,"location.png",null,null,28,28);
	HomePcs.map._MapApp.addOverlay(initMarker);
	HomePcs.mpdzMarkerArr.push(initMarker);
	initMarker.addListener("click", function(){
		var editUrl = "/sydwgl/view?id="+id;
		menu_open("实有单位",editUrl);
	});
};
/**
 * @title:removeMap
 * @description:清除地图事件
 * @author: zhang_guoliang@founder.com
 * @param  
 * @date:2014-10-28 21:41:32
 */	
HomePcs.removeMap = function(){
	//删除地图事件_平移事件
	if(HomePcs.EventListenerPan !=""){
		HomePcs.map._MapApp.removeMapEventListener(HomePcs.EventListenerPan); 
	}
	//删除地图事件_放大缩小
	if(HomePcs.EventListenerZoom !=""){
		HomePcs.map._MapApp.removeMapEventListener(HomePcs.EventListenerZoom); 
	}
	if(HomePcs.zzjgdm!=""&&HomePcs.zzjgdm.substring(10, 12)!="00"){
	}else{
		//关闭热度
		HomePcs.eqkg = "0";
		//派出所边界
		HomePcs.moveMapToBjzbz("1");
	}
	if(GpsCtrl10){
		try{
			GpsCtrl10.HideGPS(0, true);
		}catch (e) {
		}
	}
};
/**
 * @title:back
 * @description:后退
 * @author: zhang_guoliang@founder.com
 * @param  
 * @date:2014-10-25 13:41:46
 */	
HomePcs.back = function(){
	//删除地图事件_平移事件
	if(HomePcs.EventListenerPan !=""){
		HomePcs.map._MapApp.removeMapEventListener(HomePcs.EventListenerPan); 
	}
	//删除地图事件_放大缩小
	if(HomePcs.EventListenerZoom !=""){
		HomePcs.map._MapApp.removeMapEventListener(HomePcs.EventListenerZoom); 
	}
	HomePcs.queryXjZzjg_back(HomePcs.bjJson);
	/*根据图元素将地图放到最适合的级别和位置*/
	HomePcs.map._MapApp.centerAtMBR(HomePcs.Mbr);
	if(userOrgCode!="210204410000"||screen.width>1600){
		/*新版本cliect自动适应级别有问题必须降一级*/
		HomePcs.map._MapApp.zoomOut();
	}
	//组织机构名称
	$jquery("#orgZzjgmc").html(userOrgName);
	//关闭热度
	HomePcs.eqkg = "0";
	//关闭GPS
	if(GpsCtrl10){
		try{
			GpsCtrl10.HideGPS(0, true);
		}catch (e) {
		}
	}
};
/**
 * @title:initFalsh
 * @description:统计图弹出框
 * @author: zhang_guoliang@founder.com
 * @param  
 * @date:2014-10-25 16:49:48
 */	
HomePcs.initFalsh = function(bs){
	var tjflash = new FrameTools.FloatWin("实有人口统计图","mapDiv",600,400,null,null,60,null,250,1,1);
	var queryTjHTML = " <iframe style='width: 100%;height: 100%;' noresize scrolling='no' frameborder='no' src='"+contextPath+"/forward/sqjw|sqjwChart?zzjgdm="+HomePcs.zzjgdm+"&bs="+bs+"'></iframe>";
	tjflash.setOpHtml(queryTjHTML);
};
/**
 * @title:showAreaMJ
 * @description:换算面积
 * @author: zhang_guoliang@founder.com
 * @param  
 * @date:2014-10-25 16:49:48
 */	
HomePcs.showAreaMJ = function(lx,zbz){
	HomePcs.XqMJ = "";
	var strLine = zbz;
	var mj = "";
	var polyline = new Polygon(strLine,'red',"3","1","#AACEEB");
	if(lx == "15"){
		mj = polyline.getArea();
		mj = Math.round(mj*100)/100;
		HomePcs.XqMJ = mj;
	}else{
		mj = polyline.getArea()/1000000;
		mj = Math.round(mj*100)/100;
		HomePcs.XqMJ = mj;
		HomePcs.PcsXqMJ = HomePcs.XqMJ;
	}	
};
////////以下是操作地图撒点//////
if(typeof HomePage == "undefined" || !HomePage){
	var HomePage = {};
};
/**
 * @title:syrkListMBR
 * @description:实有人口统计图撒点
 * @author: zhang_guoliang@founder.com
 * @param  
 * @param   
 * @date:2014-07-16 20:27:32
 */	
HomePage.syrkListMBR = function(lx){
	alert(lx)
	HomePcs.removeMap();
	$(document.getElementById("tdmapid")).mask("数据加载中...");
	var params = {lx:lx,zzjgdm:HomePcs.zzjgdm};
	var fajax =new FrameTools.Ajax(contextPath+"/xj/querySyrkList",HomePage.syrkListMBR_back);
	fajax.send(params);
};
/**
 * @title:syrkListMBR_back
 * @description:实有人口统计图撒点_回调函数
 * @author: zhang_guoliang@founder.com
 * @param  
 * @param   
 * @date:2014-07-16 20:28:43
 */	
HomePage.syrkListMBR_back = function(json){
	//关闭所有器已经打开的气泡框
	HomePcs.map._MapApp.closeInfoWindow();
	//清空已存在坐标点
	if(HomePcs.mpdzMarkerArr != null){
		var markerLen = HomePcs.mpdzMarkerArr.length;
		for(var j=0;j<markerLen;j++){
			HomePcs.map._MapApp.removeOverlay(HomePcs.mpdzMarkerArr[j]);
		}
	}
	//加载坐标点以及气泡框
	var listLen = json.length;
	for(var i=0;i<listLen;i++){
		HomePcs.openCh(json[i].mlphqc,json[i].zbx,json[i].zby,json[i].bzdzid);
	}
	$(document.getElementById("tdmapid")).unmask();
};
/**
 * @title:openCh
 * @description:打开层户结构
 * @author: zhang_guoliang@founder.com
 * @param  
 * @date:2014-10-28 19:47:12
 */	
HomePcs.openCh = function(mc,zbx,zby,dz_jzdzdm){
	var initMarker = HomePcs.map.initMarker(mc,zbx,zby,"location.png",null,null,28,28);
	HomePcs.map._MapApp.addOverlay(initMarker);
	HomePcs.mpdzMarkerArr.push(initMarker);
	initMarker.addListener("click", function(){
		if(dz_jzdzdm!=null&&dz_jzdzdm!=""){
		     var hsUrl = "/forward/sqjw|building|buildingShow?bzdzid="+dz_jzdzdm+"&bs=3";
		     menu_open("层户结构",hsUrl);
	    }else{
	       $.messager.alert("提示","暂无层户结构信息","info");
	    }
	});
};
/**
 * @title:mapClean
 * @description:清除地图撒点
 * @author: zhang_guoliang@founder.com
 * @param  
 * @date:2014-10-27 14:28:32
 */	
HomePage.mapClean = function(){
	//清空已存在坐标点
	if(HomePcs.mpdzMarkerArr != null){
		var markerLen = HomePcs.mpdzMarkerArr.length;
		for(var j=0;j<markerLen;j++){
			HomePcs.map._MapApp.removeOverlay(HomePcs.mpdzMarkerArr[j]);
		}
	}
};
/**
 * @title:mapClean
 * @description:天网视频撒点
 * @author: zhang_guoliang@founder.com
 * @param  
 * @date:2014-10-27 16:28:37
 */	
HomePage.twspMap = function(){
	HomePcs.removeMap();
	$(document.getElementById("tdmapid")).mask("数据加载中...");
	var params = {zzjgdm:HomePcs.zzjgdm};
	var fajax =new FrameTools.Ajax(contextPath+"/xj/querytwspMap",HomePage.twspMap_back);
	fajax.send(params);
};
/**
 * @title:twspMap_back
 * @description:天网视频撒点_回调函数
 * @author: zhang_guoliang@founder.com
 * @param  
 * @date:2014-10-27 16:27:11
 */	
HomePage.twspMap_back = function(json){
	//关闭所有器已经打开的气泡框
	HomePcs.map._MapApp.closeInfoWindow();
	//派出所边界
	HomePcs.moveMapToBjzbz("1");
	//清空已存在坐标点
	if(HomePcs.mpdzMarkerArr != null){
		var markerLen = HomePcs.mpdzMarkerArr.length;
		for(var j=0;j<markerLen;j++){
			HomePcs.map._MapApp.removeOverlay(HomePcs.mpdzMarkerArr[j]);
		}
	}
	//加载坐标点
	var listLen = json.length;
	for(var i=0;i<listLen;i++){
		HomePage.twspBz(json[i].mc,json[i].zbx,json[i].zby,json[i].tdbmbh);
	}
	$(document.getElementById("tdmapid")).unmask();
};
/**
 * @title:twspBz
 * @description:天网视频撒点定位
 * @author: zhang_guoliang@founder.com
 * @param  
 * @date:2014-10-27 17:44:45
 */	
HomePage.twspBz = function(mc,zbx,zby,tdbmbh){
	var initMarker = HomePcs.map.initMarker(mc,zbx,zby,"sxt.png",null,null,30,30);
	HomePcs.map._MapApp.addOverlay(initMarker);
	HomePcs.mpdzMarkerArr.push(initMarker);
	initMarker.addListener("click", function(){
		 var hsUrl = "http://10.80.128.83/modules/thirdParty/playwin.jsp?cameraIndexCode="+tdbmbh;
	     menu_open(mc,hsUrl);
	});
};
/**
 * @title:hottest
 * @description:实有人口热度分析
 * @author: zhang_guoliang@founder.com
 * @param  
 * @date:2014-10-27 19:02:42
 */
HomePage.hottest = function(){
	$(document.getElementById("tdmapid")).mask("热度数据加载中...");
	if(HomePcs.eqkg == "0"){
		if(HomePcs.zzjgdm!=""&&HomePcs.zzjgdm.substring(10, 12)!="00"){
		}else{
			//打开地图放大缩小监听
			HomePcs.eqkg = "1";
			//派出所边界
			HomePcs.moveMapToBjzbz("1");
		}
	}
	var obj=new ezbuilderAPI.heatmap.HeatMapBean();
    obj.ALPHA="70";  //透明度
    obj.X="ZBX";    //x坐标字段名
    obj.Y="ZBY";    //y坐标字段名
    if(HomePcs.zzjgdm!=""&&HomePcs.zzjgdm.substring(10, 12)!="00"){
    	 obj.WHERE=" ZRQDM='"+HomePcs.zzjgdm+"' AND DZJB ='10' ";//条件
	}else{
		 obj.WHERE=" PCSDM='"+HomePcs.zzjgdm+"' AND DZJB ='10' ";//条件
	}
    obj.tablename="BZDZ_BZDZXXB";//表名
    obj.gisuser="jwzh";     //表的拥有者，数据库用户名
    obj.radiusstr=25;       //渲染半径
    obj.xrfz = 1;           //渲染阀值
    obj.tpgs = 1;           //图片格式
    HomePage.gethotmappicurl("mapDiv",HomePcs.map,obj);
};
/**
 * @title:gethotmappicurl
 * @description:实有人口热度分析_具体方法
 * @author: zhang_guoliang@founder.com
 * @param  
 * @date:2014-10-27 19:05:12
 */
var uOverLay = null;
HomePage.gethotmappicurl = function(mapDiv,mapObj,queryobj,callback){
	var bound=HomePcs.map._MapApp.getBoundsLatLng(); 
    var extent=bound.minX+","+bound.minY+","+bound.maxX+","+bound.maxY;//地图屏幕范围坐标（聚合时需要的参数）
    queryobj.zbstr = extent;
	var mapWidth=parseInt(document.getElementById(mapDiv).clientWidth);//地图的宽度像素值（聚合时需要的参数）
	queryobj.WIDTH =mapWidth;  //地图宽度
	ezbuilderAPIAjax.setClientUrl(contextPath);//客户端url地址
    var org=new ezbuilderAPI.heatmap();
    org.setUserId("admin"); 
    org.gethotmappicurl(queryobj,function(json){
    	if(uOverLay)
    	HomePcs.map._MapApp.removeOverlay(uOverLay);
	    var data2 = eval("("+json.resultJson+")"); 
	    var uIcon = new Icon();
	    uIcon.image =data2[0].heatmapUrl;
		uIcon.height =parseInt(document.getElementById(mapDiv).clientHeight) ;
		uIcon.width = mapWidth
	    var point= bound.getCenterPoint();	
		uOverLay = new Marker(point,uIcon);
		var aa = HomePcs.map._MapApp.addOverlay(uOverLay);
		if(callback){
			callback();
		}
		$(document.getElementById("tdmapid")).unmask();
    } );
};
/**
 * @title:openXlc
 * @description:打开GPS巡逻车
 * @author: zhang_guoliang@founder.com
 * @param  
 * @date:2014-11-21 17:00:24
 */
HomePcs.openXlc = function(){
	HomePcs.removeMap();
	HomePcs.loadGPS(HomePcs.map._MapApp);
};
/**
 * @title:loadGPS
 * @description:加载GPS巡逻车和350M
 * @author: zhang_guoliang@founder.com
 * @param  
 * @date:2014-11-21 17:02:12
 */
HomePcs.loadGPS = function(obj){
	var mapDiv  = document.getElementById("mapDiv");
    ezgps = new ezGpsLib.Component(mapDiv,p_ServerObj,p_TrackServerObj);
    if(!ezgps.getCtrlObj("data").checkversion()){
    	return;
    }
    globalCtrl.loadXML();
    //加载GPS
    HomePcs.queryPcs();
    ezgps.Loading(obj);
	ezgps.OnMapChange();
};
/**
 * @title:queryPcs
 * @description:查询派出所以上组织机构代码将其隐藏
 * @author: zhang_guoliang@founder.com
 * @param  
 * @date:2014-11-21 17:02:12
 */
HomePcs.queryPcs = function(){
	var params = {};
	var fajax =new FrameTools.Ajax(contextPath+"/xj/queryPcs",HomePcs.queryPcs_back);
	fajax.send(params);
};
/**
 * @title:queryPcs_back
 * @description:查询派出所以上组织机构代码将其隐藏_回调函数
 * @author: zhang_guoliang@founder.com
 * @param  
 * @date:2014-11-21 17:43:21
 */
HomePcs.queryPcs_back = function(json){
	var listLen = json.length;
	for(var i=0;i<listLen;i++){
		if(json[i].zzjgdm!=userOrgCode){
			GpsMsgCtrl.DisplayORG1(json[i].zzjgdm,false);
		}
	}
};