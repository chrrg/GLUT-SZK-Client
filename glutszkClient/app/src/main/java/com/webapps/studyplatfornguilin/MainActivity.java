package com.webapps.studyplatfornguilin;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
public class MainActivity extends Activity{
    public WebView webview;
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
//            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.WHITE);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            this.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        setContentView(R.layout.activity_main);
        webview = findViewById(R.id.webView);//赋值webview
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);// 打开本地缓存提供JS调用,至关重要
        webSettings.setAllowFileAccess(true);
        webSettings.setAppCacheEnabled(true);
        String appCachePath = getApplication().getCacheDir().getAbsolutePath();
        webSettings.setAppCachePath(appCachePath);
        webSettings.setDatabaseEnabled(true);
        webview.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                if (handler != null) handler.proceed();//忽略证书的错误继续加载页面内容，不会变成空白页面
            }
            public void onPageFinished(final WebView view, String url) {
                super.onPageFinished(view, url);
                //加载完成
                //Toast.makeText(MainActivity.this,"网络不稳定",Toast.LENGTH_SHORT).show();
                String js;
                js="!function(){var a,b,c,d,e;try{if(window.is_VUEBind)return;a=[],window.is_VUEBind=!0,window.begin=!1,b=function(a){return\"A\"==a?0:\"B\"==a?1:\"C\"==a?2:\"D\"==a?3:\"E\"==a?4:\"F\"==a?5:!1},c=function(){return s._route.matched[0].instances.default.currentIndex},d=function(){s._route.matched[0].instances.default.form[c()].answer=[]},window.getAuto=function(){var a,e;for(d(),a=s._route.matched[0].instances.default.questions[c()].modelAnswer,e=0;e<a.length;e++)b(a[e])!==!1&&document.getElementsByClassName(\"answer-list van-checkbox-group\")[0].children[b(a[e])].click()},window.getAuto2=function(){var b,c,e,f,g,h;d(),b=document.querySelector(\".question-box .title\").innerText.trim();for(c in a)if(a[c][0]==b){for(e=a[c][1],f=document.getElementsByClassName(\"answer-list van-checkbox-group\")[0].children,g=0;g<f.length;g++)for(h=0;h<e.length;h++)f[g].innerText.substr(2).trim()==e[h].trim()&&f[g].click();break}},e=setInterval(function(){try{s._route.matched[0].instances.default.questions[0].modelAnswer&&(begin=!0,clearInterval(e),alert(\"网络不稳定！错误码：0x0\"+s._route.matched[0].instances.default.questions[0].modelAnswer))}catch(a){}},1e3),a=[[\"毛泽东在“文化大革命”时期提出的正确理论之一是\",[\"三个世界划分理论\"]],[\"毛泽东在《反对本本主义》一文中反对的主要错误倾向是\",[\"教条主义\"]],[\"毛泽东（中国共产党人）第一次提出反对教条主义的重要文章是\",[\"《反对本本主义》\"]],[\"做到实事求是的基本前提是\",[\"一切从实际出发\"]],[\"毛泽东思想的精髓和根本出发点是\",[\"实事求是\"]],[\"做到实事求是的根本途径和方法是\",[\"理论联系实际\"]],[\"中国共产党一切工作的根本路线是\",[\"群众路线\"]],[\"中国革命和建设的基本立足点是\",[\"独立自主，自力更生\"]],[\"中国民主主义革命经历了旧民主主义革命和新民主主义革命两个阶段，“旧”阶段转化到“新”阶段的根本标志是\",[\"中国革命领导阶级的变化\"]],[\"中国抗日民族统一战线中的中间势力包括\",[\"地方实力派\",\"开明绅士\",\"民族资产阶级\"]],[\"中国共产党在抗日民族统一战线中的策略总方针包括\",[\"发展进步势力\",\"争取中间势力\",\"孤立顽固势力\"]],[\"毛泽东提出的中国共产党处理与民主党派关系的基本方针是\",[\"长期共存\",\"互相监督\"]],[\"根据毛泽东的提议，周恩来在全国人大三届一次会议上正式宣布我国实现社会主义现代化的目标是实现社会主义的\",[\"工业现代化\",\"农业现代化\",\"国防现代化\",\"科学技术现代化\"]],[\"20世纪50年代中期，集中体现毛泽东探索中国社会主义建设道路所取得的理论成果的著作有\",[\"《论十大关系》\",\"《关于正确处理人民内部矛盾的问题》\"]],[\"第一次国民革命时期，毛泽东在（    ）等著作中，分析了中国社会各阶级在革命中的地位和作用，提出了新民主主义革命的基本思想。\",[\"《中国社会各阶级的分析》\",\"《湖南农民运动考察报告》\"]],[\"毛泽东指出社会主义社会的基本矛盾是\",[\"生产关系和生产力之间的矛盾\",\"上层建筑和经济基础之间的矛盾\"]],[\"第一次提出毛泽东思想概念的是刘少奇。\",[\"错误\"]],[\"把马克思列宁主义原理同中国革命实际相结合，实现第一次历史性飞跃的代表人物是毛泽东。\",[\"正确\"]],[\"在中共六届七中全会上把毛泽东思想确定为党的指导思想。\",[\"错误\"]],[\"作为党的思想路线“实事求是”中的“是”是指客观存在着的一切事物。\",[\"错误\"]],[\"中国共产党成立前后，马克思列宁主义在中国的广泛传播为毛泽东思想的萌芽准备了科学的世界观和方法论基础。\",[\"正确\"]],[\"什么是新民主主义革命，如何进行新民主主义革命的问题是毛泽东思想首要的基本理论问题。\",[\"错误\"]],[\"毛泽东思想的产生不是偶然的，它是近代中国社会矛盾发展需要的必然产物。\",[\"正确\"]],[\"党的七大召开前后是毛泽东思想的初步形成时期。\",[\"错误\"]],[\"近代中国的社会性质是\",[\"半殖民地半封建社会\"]],[\"新民主主义革命的性质是\",[\"资产阶级民主主义革命\"]],[\"近代中国沦为半殖民地半封建社会的最主要原因是\",[\"帝国主义的侵略\"]],[\"在近代中国社会，中国人民第一个最凶恶的敌人是\",[\"帝国主义\"]],[\"阻碍近代中国经济发展和社会进步的最根本原因是\",[\"封建主义的腐朽统治\"]],[\"近代中国的民族资本主义\",[\"始终没有成为中国社会经济的主要形式\"]],[\"近代中国社会各种矛盾中最主要的矛盾是\",[\"帝国主义和中华民族的矛盾\"]],[\"20世纪中国发生的第一次历史性巨变是\",[\"辛亥革命\"]],[\"中国新民主主义革命的开端是\",[\"五四运动\"]],[\"新旧民主主义革命的根本区别是革命的对象不同。\",[\"错误\"]],[\"新民主主义革命的伟大胜利为当代中国发展进步奠定了根本政治前提。\",[\"正确\"]],[\"武装斗争是中国革命的唯一形式。\",[\"错误\"]],[\"中国资产阶级包括官僚资产阶级、民族资产阶级和城市小资产阶级。\",[\"错误\"]],[\"中国新民主主义革命既可以走农村包围城市的道路，也可以走城市武装起义的道路。\",[\"错误\"]],[\"新民主主义革命理论达到成熟是在抗日战争时期。\",[\"正确\"]],[\"新民主主义革命理论的核心问题是农民问题。\",[\"错误\"]],[\"新民主主义社会五种经济成分中，居于领导地位的是（     ）\",[\"国营经济\"]],[\"新民主主义社会时期，土地改革完成后的主要矛盾是（     ）\",[\"工人阶级和资产阶级的矛盾\"]],[\"新中国在对资本主义工商业实行社会主义改造的过程中，在实行全行业的公私合营之前采取的利润分配政策是（     ）\",[\"四马分肥\"]],[\"新中国成立后，中共中央提出的过渡时期的总路线的实质是（    ）\",[\"使生产资料的社会主义所有制成为我国国家和社会的唯一的经济基础\"]],[\"资本主义私有制过渡到完全的社会主义公有制的具有决定意义的重大步骤是（      ）\",[\"全行业公私合营\"]],[\"我党在过渡时期的总路线的主要内容可以简单地概括为“一化三改”，其中“三改”其实就是要变革（    ）\",[\"生产关系\"]],[\"在由新民主主义向社会主义改造过程中，对生产资料私有制进行社会主义改造的目的是（   ）\",[\"解放和发展生产力\"]],[\"中华人民共和国的成立标志着(   )\",[\"半殖民地半封建社会结束\",\"中国进入新民主主义社会\",\"新民主主义革命基本胜利\"]],[\"我国新民主主义社会向社会主义社会转变的开端是过渡时期总路线的公布\",[\"错误\"]],[\"党的过渡时期总路线的两翼是实现国家发展的工业化\",[\"错误\"]],[\"新中国进入社会主义初级阶段的标志是社会主义改造的基本完成\",[\"正确\"]],[\"过渡时期总路线的最显著特点是先合作化后工业化\",[\"错误\"]],[\"社会主义改造的基本完成标志着社会主义制度在中国的确立\",[\"正确\"]],[\"我国对个体农业与手工业的社会主义改造采取的都是积极领导、稳步前进的方针\",[\"正确\"]],[\"毛泽东指出，用民主的方法解决人民内部矛盾，这是一个总方针，针对人民内部矛盾在具体实践中的不同情况，又有一系列具体方针，对于民族之间的矛盾，实行（      ）的方针\",[\"民族平等、团结互助\"]],[\"在《论十大关系》和《关于正确处理人民内部矛盾的问题》中，毛泽东都明确提出了中国工业化道路的问题，指出以工业为主导，把（   ）作为我国经济建设的重点，以逐步建立独立的比较完整的基础工业体系和国防工业体系\",[\"重工业\"]],[\"“这次成功的试验，标志着我国国防现代化进入了一个新的阶段。这对美帝国主义核垄断、核讹诈的政策是一个有力的打击，对全世界爱好和平的人民是一个极大的鼓舞。”这是中共中央、国务院向一次成功的试验现场发的贺电，这次成功的试验是指（  ）\",[\"1964年10月第一颗原子弹爆炸成功\"]],[\"在探索建设社会主义道路中，广大人民和干部中涌现出大批先进人物，其中被誉为“两弹元勋”的是（   ）\",[\"邓稼先\"]],[\"中共八大在探索中国自己的社会主义建设道路方面最重要的贡献是（   ）\",[\"对当时和其后一个时期我国社会主义条件的阶级状况、社会状况及国情的判断，主要矛盾和党的主要任务的分析是基本正确的\"]],[\"新中国的工业化是在苏联的影响下起步的，走中国工业化道路，是中国共产党初步探索我国社会主义建设道路的一个重要思想，当时所讲的工业化道路问题，主要是指（  ）\",[\"重工业、轻工业和农业的发展关系问题\"]],[\"“阶级斗争基本结束，但没有完全结束”出自（    ）\",[\"《关于正确处理人民内部矛盾的问题》\"]],[\"邓小平指出，建国以后我们在社会主义建设中所经历的曲折和失误，改革开放过程遇到的一些疑虑和困扰，归根到底，就在于没有完全搞清楚（）\",[\"什么是社会主义，怎样建设社会主义\"]],[\"毛泽东提出社会主义建设要“以苏为鉴”，是在（）\",[\"苏共20大以后\"]],[\"腾讯网在我国成立六十周年时发起了“大国脚印˙网友票选60年最具影响力的历史事件”评选活动。其中，1953年当选的历史事件是第一个五年计划的开始实施。网友选此事件的主要原因是“一五”计划（）\",[\"有力地配合了“三大改造”的进行\",\"“一五”计划是社会主义工业化建设的起步\",\"激发了人们的生产劳动热情\"]],[\"在社会主义改造基本完成以后，由于对迅速到来的新生社会主义社会和全国规模的社会主义建设事业缺乏充分的思想准备和科学研究，对建设社会主义的客观规律缺乏深刻的认识，导致党在指导思想上发生了“左”的偏差\",[\"正确\"]],[\"毛泽东探索中国社会主义建设道路第一个标志性的重要理论成果是《关于正确处理人民内部矛盾的问题》\",[\"错误\"]],[\"社会主义制度建立后，国家政治生活的主题是正确处理人民内部矛盾和敌我矛盾\",[\"错误\"]],[\"社会主义制度建立后，工人阶级和民族资产阶级仍然存在着对抗性的矛盾，因此属于敌我矛盾的范畴\",[\"错误\"]],[\"强大的国防力量是维护国家安全的重要保障，伴随着中国核工业和导弹事业的发展而诞生的部队是中国战略导弹部队\",[\"正确\"]],[\"毛泽东在《论十大关系》中论述的第一大关系就是重工业、轻工业和农业的关系\",[\"正确\"]],[\"在初步探索建设社会主义道路过程中，刘少奇提出了“三个主体，三个补充”的设想\",[\"错误\"]],[\"为改变兰考的落后面貌，他深入群众，摸清灾情，带领全县人民生产自救，被誉为“县委书记的榜样”的是王进喜\",[\"错误\"]],[\"所谓专政方法，就是运用人民民主专政的国家机器，对于国家内部那些反抗社会主义改造，破坏社会主义建设的敌对分子和严重犯罪分子依法治罪并进行改造\",[\"正确\"]],[\"1958年，中共八大二次会议通过的社会主义建设总路线及其基本点，其正确的一面是反映了广大人民群众迫切要求改变我国经济文化落后状况的普遍愿望，其缺点是忽视了客观的经济规律\",[\"正确\"]],[\"中国共产党第八次全国代表大会是探索建设社会主义道路的一次重要的会议，这次会议首次提出了改革开放\",[\"错误\"]],[\"人民公社极大地妨碍了农业生产发展的根本原因是超越了我国生产力发展的实际水平\",[\"正确\"]],[\"邓小平理论的精髓是\",[\"解放思想，实事求是\"]],[\"邓小平重新确定实事求是思想路线的重要讲话是\",[\"《解放思想，实事求是，团结一致向前看》\"]],[\"（）是邓小平和我们党对当代中国基本国情的科学判断。\",[\"我国仍处在社会主义初级阶段\"]],[\"邓小平丰富和发展实事求是思想路线的内容，其中不包括\",[\"初步提出了“三个代表”重要思想\"]],[\"（）果断作出了把党和国家工作重点转移到社会主义现代化建设上来的战略决策，标志着党重新确立了马克思主义的思想路线。\",[\"党的十一届三中全会\"]],[\"下列论断中，不属于邓小平南方谈话内容的是\",[\"实践是检验真理的唯一标准\"]],[\"下面关于社会主义初级阶段理论的论述，不正确的是\",[\"社会主义初级阶段是所有国家进入社会主义都必须经历的特定阶段\"]],[\"建设中国特色社会主义的总依据是\",[\"社会主义初级阶段理论\"]],[\"党的十九大将（）纳入基本路线，而且将“现代化国家”提升为“现代化强国”，扩展了党的基本路线的内涵。\",[\"美丽\"]],[\"（）是社会主义社会发展的直接动力。\",[\"改革\"]],[\"（）是中国特色社会主义理论体系的开篇之作。\",[\"邓小平理论\"]],[\"邓小平理论逐步走向成熟的标志是\",[\"南方谈话\"]],[\"哪一次会议第一次比较系统地论述了我国社会主义初级阶段理论，第一次对中国特色社会主义理论的主要内容作了系统概括。\",[\"党的十三大\"]],[\"社会主义的根本任务是\",[\"发展生产力\"]],[\"关于“一国两制”的认识，正确的是（）\",[\"坚持一个中国是“和平统一、一国两制”的核心，是发展两岸关系和实现和平统一的基础\",\"高度自治，祖国完全统一后，台湾、香港、澳门作为特别行政区，享有不同于中国其他省、市、自治区的高度自治权\",\"两制并存，在祖国统一的前提下，国家的主体部分实行社会主义制度，同时在台湾、香港、澳门保持原有的社会制度和生活方式长期不变\"]],[\"邓小平提出（）新论断，反映了科学技术在当代发展的新形势和对我国现代化建设的新要求。\",[\"科学技术是第一生产力\"]],[\"关于“一国两制”的认识，正确的是（）\",[\"体现了坚持祖国统一、维护国家主权的原则性\",\"体现了照顾历史实际和现实可能的灵活性\",\"是对马克思主义国家学说的创造性发展\"]],[\"邓小平“三步走”的发展战略，指的是（）\",[\"从1981年到1990年实现国民生产总值比1980年翻一番，解决人民的温饥饱问题\",\"从1991年到20世纪末，使国民生产总值再翻一番，达到小康水平\",\"到21世纪中叶，国民生产总值再翻两番，达到中等发达国家水平，基本实现现代化。\"]],[\"下面关于思想路线的认识，正确的是（）\",[\"党的十一届三中全会重新确立了实事求是的思想路线\",\"是邓小平理论的活的灵魂\",\"有力地推动和保证了改革开放的进行\",\"是邓小平理论的精髓\"]],[\"下面关于四项基本原则与改革开放的关系，正确的是（）\",[\"四项基本原则保证改革开放的正确方向\",\"改革开放赋予四项基本原则新的时代内涵\",\"两者统一于发展中国特色社会主义的伟大实践\"]],[\"下面关于“一个中心”与“两个基本点”的关系，正确的是（）\",[\"“以经济建设为中心”回答了社会主义的根本任务问题\",\"“坚持四项基本原则”回答了解放和发展生产力的政治保证问题\",\"“坚持改革开放”回答了社会主义的发展动力和外部条件问题\",\"两者是一个整体，集中体现了我国社会主义现代化建设的战略布局，揭示了中国特色社会主义的客观规律和发展道路。\"]],[\"坚持“四项基本原则”，指的是（）\",[\"坚持社会主义道路\",\"坚持人民民主专政\",\"坚持中国共产党的领导\"]],[\"和平与发展成为时代主题是邓小平理论形成的时代背景。\",[\"正确\"]],[\"社会主义建设的经验教训是邓小平理论形成的现实依据。\",[\"错误\"]],[\"改革开放和现代化建设的实践是邓小平理论形成的现实依据。\",[\"正确\"]],[\"党的十二大重新确立了解放思想、实事求是的思想路线。\",[\"错误\"]],[\"习近平总书记是中国社会主义改革开放和现代化建设的总设计师。\",[\"错误\"]],[\"党的十三大第一次比较系统地论述了我国社会主义初级阶段理论。\",[\"正确\"]],[\"党的十五大第一次对中国特色社会主义理论进行系统的概括，标志着邓小平理论轮廓的形成。\",[\"错误\"]],[\"南方谈话是邓小平理论的集大成之作，标志着邓小平理论逐步走向成熟。\",[\"正确\"]],[\"党的十六大把邓小平理论确立为党的指导思想并写入党章。\",[\"错误\"]],[\"到20世纪末，人民生活总体上达到小康水平。这个小康是（）\",[\"低水平的\",\"不全面的\",\"不平衡的\"]],[\"下面关于对“三个代表”重要思想的认识，正确的是（）\",[\"是中国特色社会主义理论体系的重要组成部分\",\"强调社会主义社会是全面发展、全面进步的社会，衡量党的方针政策的成败得失，必须坚持全面性的标准\",\"强调要努力促进人的全面发展\",\"赋予了党的指导思想、党的宗旨和党的任务以鲜明的时代内容和时代特征，形成了崭新的马克思主义建党学说。\"]],[\"“三个代表”重要思想的主要内容包括（）\",[\"发展是党执政兴国的第一要务\",\"建立社会主义市场经济体制\",\"建设社会主义政治文明\",\"推进党的建设新的伟大工程\"]],[\"“三个代表”重要思想的核心观点是（）\",[\"先进社会生产力的发展要求\",\"最广大人民的根本利益\",\"先进文化的前进方向\"]],[\"发展社会主义先进文化，就是发展（）的社会主义文化。\",[\"面向现代化\",\"面向世界\",\"面向未来\"]],[\"进一步探索公有制特别是国有制的多种有效实现形式，必须按照（）的要求，实行规范的公司制改革，完善法人治理结构。\",[\"产权清晰\",\"权责明确\",\"政企分开\",\"管理科学\"]],[\"“三个代表”重要思想是在对冷战结束后国际局势科学判断的基础上形成的\",[\"正确\"]],[\"江泽民在庆祝中国共产党成立80周年大会上首次对“三个代表”进行了比较全面的阐述。\",[\"错误\"]],[\"党的十七大将“三个代表”重要思想确立为党的指导思想，并写入党章。\",[\"错误\"]],[\"科技进步和创新是发展生产力的决定因素\",[\"正确\"]],[\"建立社会主义市场经济体制，必须毫不动摇地鼓励、支持和引导非公有制经济发展\",[\"正确\"]],[\"全面建设小康社会，是实现现代化建设第三步战略目标必经的承上启下的发展阶段\",[\"正确\"]],[\"领导干部一定要讲学习，讲政治，讲正气。其中，讲学习是核心，讲政治是前提。\",[\"错误\"]],[\"“三个代表”重要思想在邓小平理论的基础上，进一步回答了实现什么样的发展，怎样发展的问题。\",[\"错误\"]],[\"“三个代表”重要思想是加强和改进党的建设，推进中国特色社会主义事业的强大理论武器。\",[\"正确\"]],[\"“三个代表”重要思想是在科学判断党的历史方位和总结历史经验的基础上提出来的。\",[\"正确\"]],[\"科学发展观的第一要义是（）\",[\"推动经济社会发展\"]],[\"科学发展观的基本要求是（）\",[\"全面协调可持续\"]],[\"科学发展观回答了这样一个问题（    ）\",[\"实现什么样的发展，怎样发展\"]],[\"科学发展观的根本方法是（）\",[\"统筹兼顾\"]],[\"科学发展观形成的现实依据是（    ）\",[\"社会主义初级阶段基本国情和新的阶段性特征\"]],[\"科学发展观形成的实践基础是（）\",[\"深入总结改革开放以来特别是十六大以来的实践经验\"]],[\"科学发展观产生于我国改革发展的关键阶段，它是因为（）的情况，必须推动社会科学发展、和谐发展。\",[\"思想观念深刻变化\",\"社会结构深刻变动\",\"经济体制深刻变革\",\"利益格局深刻调整\"]],[\"我国坚持文明发展的道路，需要把生态文明建设放在突出地位，需要处理好（）的关系。\",[\"经济建设与资源利用\",\"人口增长与资源利用\",\"经济建设与生态环境保护\",\"人口增长与生态环境保护\"]],[\"社会主义协商民主充分体现了社会主义民主的（）。\",[\"广泛性\",\"真实性\",\"包容性\"]],[\"依法治国的关键是（）。\",[\"依法执政\",\"依法行政\",\"依法办事\",\"公正司法\"]],[\"科学发展观形成发展的社会历史条件是改革开放和社会主义建设。（）\",[\"错误\"]],[\"社会主义文化发展道路必须坚持“三贴近”，包括（）。\",[\"贴近实际\",\"贴近生活\",\"贴近群众\"]],[\"发展生产力是科学发展观的核心立场。（）\",[\"错误\"]],[\"科学发展观中强调全面发展，这里“全面”是整体性（）。\",[\"正确\"]],[\"科学发展观中强调协调发展，这里“协调”是指均衡性。（）\",[\"正确\"]],[\"科学发展观中强调可持续发展，这里“可持续”是指持久性和连续性。\",[\"正确\"]],[\"科学发展观认为要坚持全面发展就要正确认识和把握经济、政治、科技和道德建设的相互关系。\",[\"错误\"]],[\"坚持全面发展，就是要按照中国革命的总体趋势，正确认识和处理好革命与战争、建设与斗争的关系问题。\",[\"错误\"]],[\"坚持协调发展，就是保证中国改革开放事业在各个领域顺利推进。\",[\"错误\"]],[\"由于资源用途的有限性，发展经济必须牺牲生态环境来取得发展，是工业化过程的必经阶段。\",[\"错误\"]],[\"必须认识到，我国社会主要矛盾的变化，没有改变我们对我国社会主义所处历史阶段的判断，我国仍处于并将长期处于（  ）的基本国情没有变。\",[\"社会主义初级阶段\"]],[\"中国特色社会主义法律体系以（  ）为核心。\",[\"宪法\"]],[\"发展的根本目的是（  ）。\",[\"增进民生福祉\"]],[\"把习近平新时代中国特色社会主义思想确立为党的指导思想是在（  ）次会议上。\",[\"十九大\"]],[\"实现中华民族伟大复兴的行动指南是（  ）。\",[\"习近平新时代中国特色社会主义思想\"]],[\"把习近平新时代中国特色社会主义思想载入宪法是在（  ）上。\",[\"十三届全国人大一次会议\"]],[\"党的十八届五中全会提出坚持（   ）的发展思想。\",[\"以人民为中心\"]],[\"新时代党和人民共同奋斗的精神旗帜是（   ）。\",[\"习近平新时代中国特色社会主义思想\"]],[\"党的十九大以如椽巨笔书写了民族复兴的“未来简史”，（  ）是坐标。\",[\"新时代\"]],[\"党的十九大以如椽巨笔书写了民族复兴的“未来简史”，（  ）是底色。\",[\"强起来\"]],[\"党的十九大以如椽巨笔书写了民族复兴的“未来简史”，（  ）是灵魂。\",[\"新思想\"]],[\"习近平新时代中国特色社会主义思想坚持以社会主义现代化建设进程中的实际问题，以我们正在做的事情为中心，着眼统揽（  ）。\",[\"伟大斗争\",\"伟大工程\",\"伟大事业\",\"伟大梦想\"]],[\"实现党在新时代的强军目标，坚持（  ）。\",[\"政治建军\",\"改革强军\",\"科技兴军\",\"依法治军\"]],[\"中国特色社会主义既坚持科学社会主义基本原则，又具有鲜明（  ）。\",[\"实践特色\",\"理论特色\",\"民族特色\",\"时代特色\"]],[\"新时代的内涵是（  ）。\",[\"承前启后、继往开来，在新的历史条件下继续夺取中国特色社会主义伟大胜利的时代\",\"决胜全面建成小康社会、进而夺取全面建设社会主义现代化强国的时代\",\"全国各族人民团结奋斗、不断创造美好生活、逐步实现全体人民共同富裕的时代\",\"全体中华儿女勠力同心、奋力实现中华民族伟大复兴中国梦的时代\",\"我国日益走向世界舞台中央、不断为人类作出更大贡献的时代\"]],[\"我国社会主要矛盾的变化已经改变我国社会主义所处初级阶段的判断。\",[\"错误\"]],[\"实现中华民族伟大复兴的战略支撑是坚持党对人民军队的绝对领导。\",[\"正确\"]],[\"发展的根本目的是国家长治久安。\",[\"错误\"]],[\"把习近平新时代中国特色社会主义思想载入宪法是在党的十九大。\",[\"错误\"]],[\"我国国内生产总值自2010年开始稳居世界第二位。\",[\"正确\"]],[\"坚持以人民为中心的发展思想的提出是在党的十八大。\",[\"错误\"]],[\"新时代党和人民共同奋斗的精神旗帜是毛泽东思想和中国特色社会主义理论体系。\",[\"错误\"]],[\"习近平用（  ）诗句叙说中华民族的明天。\",[\"长风破浪会有时\"]],[\"中国梦归根结底是（  ）。\",[\"人民的梦\"]],[\"中国梦的主体是（  ）。\",[\"人民\"]],[\"实现中国梦必须走中国道路，这就是（  ）。\",[\"中国特色社会主义道路\"]],[\"中国梦的根本归宿在于（  ）。\",[\"人民\"]],[\"中国梦的深厚源泉在于（  ）。\",[\"人民\"]],[\"实现中国梦必须凝聚中国力量，这就是（  ）。\",[\"全国各族人民大团结的力量\"]],[\"近代以来中华民族最伟大的梦想是（  ）。\",[\"实现中华民族伟大复兴\"]],[\"中华民族伟大复兴的形象表达是（  ）。\",[\"中国梦\"]],[\"习近平首次提出“中国梦”这个概念是在（  ）年。\",[\"2012\"]],[\"实现中华民族伟大复兴的中国梦把（  ）融为一体。\",[\"国家的追求\",\"民族的向往\",\"人民的期盼\"]],[\"习近平用（  ）诗句将中华民族的昨天、今天和明天熔铸于百余年中国沧桑巨变的历史图景。\",[\"雄关漫道真如铁\",\"人间正道是沧桑\",\"长风破浪会有时\"]],[\"实现中华民族伟大复兴的中国梦是（  ）相统一的梦。\",[\"国家情怀\",\"民族情怀\",\"人民情怀\"]],[\"实现中国梦必须（  ）。\",[\"走中国道路\",\"弘扬中国精神\",\"凝聚中国力量\"]],[\"实现中国梦必须弘扬中国精神，这就是（  ）和（  ）。\",[\"以爱国主义为核心的民族精神\",\"以改革创新为核心的时代精神\"]],[\"中国特色社会主义总任务所要回答的问题包括（  ）。\",[\"按照什么样的时间表\",\"按照什么样的路线图\",\"进一步追梦圆梦\",\"实现关键一跃\"]],[\"国家富强、民族振兴、人民幸福三者之间的辩证关系是（  ）。\",[\"国家富强、民族振兴是人民幸福的基础和保障\",\"人民幸福是国家富强、民族振兴的题中之义\",\"人民幸福是国家富强、民族振兴的必然要求\",\"人民幸福是国家富强、民族振兴的根本出发点\",\"人民幸福是国家富强、民族振兴的落脚点\"]],[\"中华民族伟大复兴的形象表达是中国梦。\",[\"正确\"]],[\"习近平首次提出“中国梦”这个概念是在2012年。\",[\"正确\"]],[\"实现中国梦必须弘扬以爱国主义为核心的民族精神。\",[\"正确\"]],[\"实现中国梦必须弘扬以改革创新为核心的时代精神。\",[\"正确\"]],[\"中国梦被国际媒体称为“近年来最重要的全球变革”。\",[\"错误\"]],[\"十九大提出，全面建设社会主义现代化强国的进程分两个阶段安排。\",[\"正确\"]],[\"实现中国梦的动力是弘扬中国精神。\",[\"正确\"]],[\"党的十八届五中全会坚持以______为中心的发展思想，鲜明提出了创新、协调、绿色、开放、共享的新发展理念。\",[\"人民\"]],[\"______是引领发展的第一动力。\",[\"创新\"]],[\"贯彻新发展理念、建设现代化经济体系必须坚持______改革。\",[\"供给侧结构性\"]],[\"______是生产力中最活跃的因素。\",[\"人\"]],[\"建设现代化______体系是我国发展的战略目标，也是转变经济发展方式、优化经济结构、转换经济增长动力的迫切要求。\",[\"经济\"]],[\"______是一国经济的立身之本，是财富创造的根本源泉，是现代化经济体系的坚实基础。\",[\"实体经济\"]],[\"深入实施科教兴国战略、人才强国战略、创新驱动发展战略，努力实现到2035年跻身______国家前列的目标。\",[\"创新型\"]],[\"______是我们立党立国的根本指导思想，是中国共产党人的“真经”。\",[\"马克思主义\"]],[\"______是中国社会主义民主政治的特有形式和独特优势，是实现党的领导的重要方式。\",[\"协商民主\"]],[\"中国特色社会主义政治发展道路是近代以来中国人民长期奋斗______的必然结果，是坚持党的本质属性、践行党的根本宗旨的必然要求。\",[\"历史逻辑\",\"理论逻辑\",\"实践逻辑\"]],[\"我国是工人阶级领导的、以工农联盟为基础的人民民主专政的社会主义国家，国家一切权力属于人民，我国社会主义民主是维护人民根本利益的______的民主。\",[\"最广泛\",\"最真实\",\"最管用\"]],[\"人民代表大会制度是坚持______有机统一的根本政治制度安排，必须长期坚持、不断完善。\",[\"党的领导\",\"人民当家作主\",\"依法治国\"]],[\"2015年，中央统战工作会议强调我们党所处的历史方位、所面临的内外趋势、所肩负的使命任务发生了重大变化，越是变化大，越是要把统战工作做好，绝不能动摇。中国共产党之所以高度重视统战工作，因为统一战线是______。\",[\"夺取革命、建设与改革事业胜利的重要法宝\",\"实现中华民族伟大复兴中国梦的重要法宝\",\"中国共产党的一大政治优势\"]],[\"完善基层群众自治制度，促进群众在城乡社区治理、基层公共事务和公益事业中依法______。\",[\"自我管理\",\"自我服务\",\"自我教育\",\"自我监督\"]],[\"社会主义核心价值体系是由以下哪些方面构成？\",[\"马克思主义指导思想\",\"中国特色社会主义共同理想\",\"民族精神和时代精神\",\"社会主义荣辱观\"]],[\"建设社会主义文化强国，我们应该______。\",[\"培养高度的文化自信\",\"大力发展文化事业和文化产业\",\"提高国家文化软实力\"]],[\"我国是工人阶级领导的、以工农联盟为基础的人民民主专政的社会主义国家，国家一切权力属于人民。\",[\"正确\"]],[\"社会主义的建设事业依靠工人、农民就可以完成。\",[\"错误\"]],[\"“一国两制”中，“一国”是实行“两制”的基础，“两制”从属和派生于“一国”，并统一于“一国”之中。\",[\"正确\"]],[\"“九二共识”是两岸关系的政治基础。\",[\"错误\"]],[\"掌握意识形态工作领导权，要加快构建中国特色哲学社会科学。\",[\"正确\"]],[\"社会主义核心价值体系是在社会主义核心价值观基础上提炼出来的。\",[\"错误\"]],[\"家庭是社会的基本细胞，是人生的第一所学校。\",[\"正确\"]],[\"关于全面深化改革，下列说法错误的是______。\",[\"全面深化改革，就是要将社会所有矛盾都消灭掉。\"]],[\"十八大报告提出，解决中国现实问题的根本途径是______。\",[\"全面深化改革\"]],[\"全面推进依法治国是在______提出的。\",[\"十八届四中全会\"]],[\"改革、发展、稳定是我国社会主义现代化建设的三个重要支点，______是经济社会发展的强大动力，______是解决一切经济社会问题的关键，______是改革发展的前提。\",[\"改革、发展、稳定\"]],[\"我国进入新时代，党的执政环境遇到“四大考验”。下列不属于“四大考验”的是______。\",[\"能力不足考验\"]],[\"党的十九大明确表明，旗帜鲜明______是我们党作为马克思主义政党的根本要求。\",[\"讲政治\"]],[\"习近平总书记反复指出：“工作作风上的问题绝对不是小事，如果不坚决纠正不良风气，任其发展下去，就会像一座无形的墙把我们党和人民群众隔开，我们党就会失去根基、失去血脉、失去力量。”习总书记这句话表明了加强______的重要性。\",[\"作风建设\"]],[\"“要让权力在阳光下运行，把权力关进制度的笼子”告诫我们______。\",[\"要将制度建设贯穿党的各项建设之中\"]],[\"全面从严治党永远在路上，关键在于______。\",[\"加强党的思想建设\",\"加强党的组织建设\",\"持之以恒正风肃纪\",\"深化标本兼治，夺取反腐败斗争压倒性胜利\"]],[\"习近平反复指出：“工作作风上的问题绝对不是小事，如果不坚决纠正不良风气，任其发展下去，就会像一座无形的墙把我们党和人民群众隔开，我们党就会失去根基、失去血脉、失去力量。”因为______是关系党生死存亡的问题。\",[\"党风问题\",\"党同人民群众联系问题\"]],[\"十八届四中全会指出，加快推进反腐败国家立法，完善惩治和预防腐败体系，形成______的有效机制，坚决遏制和预防腐败现象。\",[\"不敢腐\",\"不能腐\",\"不想腐\"]],[\"中共十八届四中全会通过的《中共中央关于全面推进依法治国若干重大问题的决定》指出，坚持______一体建设，促进国家治理体系和治理能力现代化。\",[\"法治政府\",\"法治社会\",\"法治国家\"]],[\"要实现全面建成小康社会的奋斗目标，就必须缩小地区、城乡和各阶层之间的差距，为此我们要______。\",[\"加快中西部地区的发展\",\"高度重视“三农”问题\",\"振兴东北老工业基地\",\"加快城镇化建设\"]],[\"中国特色社会主义重要内容有______。\",[\"建设和谐社会\",\"依法治国\",\"建设民主社会\"]],[\"全面深化改革，关系党和人民事业前途命运，关系党的执政基础和执政地位。\",[\"正确\"]],[\"促进社会公平正义、增进人民福祉是全面深化改革的出发点和落脚点。\",[\"正确\"]],[\"中国特色社会主义进入新时代，要站在更高起点谋划和推进改革，改革是有方向、有立场、有原则、有终点的。\",[\"错误\"]],[\"政府在资源配置中起决定性作用。\",[\"错误\"]],[\"国家治理体系和治理能力是一个国家的制度和制度执行能力的集中体现，两者相辅相成。\",[\"正确\"]],[\"我国改革开放是先试验、后总结、再推广不断积累的过程。\",[\"正确\"]],[\"解放思想和实事求是相统一的，解放思想目的和实质都是为了做到实事求是。\",[\"正确\"]],[\"改革是社会主义制度自我完善和发展，不是对社会主义制度改弦易张，不实行改革开放死路一条，搞否定社会主义方向的“改革开放”也是死路一条。\",[\"正确\"]],[\"打好精准脱贫攻坚战，就是要做到脱真贫、真脱贫。\",[\"正确\"]],[\"党从思想上政治上组织上建设和掌握部队的重要组织支撑是（）。\",[\"党委、政治委员和政治机关\"]],[\"习近平提出要把人民军队建设成为世界一流军队，其时间节点是（）。\",[\"到本世纪中叶\"]],[\"衡量军队建设水平的唯一的根本标准是（）。\",[\"战斗力\"]],[\"习近平强军思想认为，推进强军事业必须坚持（）。\",[\"政治建军\",\"改革强军\",\"科技兴军\",\"依法治军\"]],[\"我国兵法历来认为，不战而屈人之兵为上上策，因此，军队只需要提高宣传力度、搞好文化展示、更新军事装备形成对敌人的威慑就可以了，不能总是时刻准备打仗。\",[\"错误\"]],[\"由于资源的有限性，富国和强军是有一定竞争性的，因此必须减少国防投入，提高经济发展速度。\",[\"错误\"]],[\"坚持富国和强军相统一是我们党的一贯主张。\",[\"正确\"]],[\"有人认为，军事部门是不生产商品的部门，因此投资于国防事业是降低市场经济效率的行为。我们应将国防预算压低到最低限度才能推动我国经济快速发展。\",[\"错误\"]],[\"国防教育是军队的职能和军人的本职，大学生只需要搞好文化学习就行了，无需进行国防教育。\",[\"错误\"]],[\"随着科技的发展，军队规模和巨大的人口已经不是战斗力的决定性因素，因此，我国坚持人民战争的战略思想已经失去了必要性。\",[\"错误\"]],[\"信息化战争已经将对抗领域从军事领域拓展到了经济、信息、文化、科技的各个方面，军民融合式发展是国防和军队现代化的必由之路。\",[\"正确\"]],[\"《孙子兵法》云：“兵者，国之大事也。”因此，国防和军队现代化是国家和军队的事情，和普通大学生没有什么关系。\",[\"错误\"]],[\"我国长期积极推动军民融合实践，取得了丰硕的成果，已经完成了深度融合，实现了军民融合式发展。\",[\"错误\"]],[\"巩固国防和强大人民军队是实现中华民族伟大复兴的战略支撑。\",[\"正确\"]],[\"改革强军就是以科技推动军事装备的发展。\",[\"错误\"]],[\"习近平强军思想认为，强军必须提高国防和军队建设法治化水平。\",[\"正确\"]],[\"坚持为群众服务是人民军队不能变的灵魂、永远不能丢的命根子。\",[\"错误\"]],[\"军队只需要搞好军事训练，可以不问政治。\",[\"错误\"]],[\"党对军队的绝对领导只是一种原则性要求，没有实质性保证。\",[\"错误\"]],[\"当今时代的主题是_____\",[\"和平与发展\"]],[\"当今世界格局发展的趋势是_____\",[\"世界多极化\"]],[\"我国处理对外关系的基本准则是_____\",[\"和平共处五项原则\"]],[\"党的_____大首次明确提出人类命运共同体意识\",[\"十八\"]],[\"目前威胁世界和平与稳定的主要根源是_____\",[\"霸权主义和强权政治\"]],[\"中国特色大国外交的首要任务是_____\",[\"为实现“中国梦”营造外部环境\"]],[\"构建人类命运共同体的基本途径不包括\",[\"加强军备建设\"]],[\"维护世界和平的政治基础是\",[\"和平共处五项原则\"]],[\"维护世界和平的经济保障是\",[\"互利合作、共同繁荣\"]],[\"维护世界和平的正确途径是\",[\"平等对话、协商谈判\"]],[\"我国正确处理国家与国家之间关系的基本外交原则是\",[\"独立自主\"]],[\"推动构建人类命运共同体，必须树立_____的新安全观\",[\"共同、综合、合作、可持续\"]],[\"推动构建人类命运共同体，要相互尊重、平等协商，坚决摒弃冷战思维，走_____的国与国交往新路\",[\"对话而不对抗、结伴而不结盟\"]],[\"推动构建人类命运共同体，要坚持_____，统筹应对传统和非传统安全威胁\",[\"以对话解决争端、以协商解决分歧\"]],[\"推动构建人类命运共同体，要同舟共济，推动经济全球化朝着更加_____的方向发展\",[\"开放、包容、普惠、平衡、共赢\"]],[\"推动构建人类命运共同体，要尊重世界文明多样性，以_____超越文明隔阂，_____超越文明冲突，文明共存超越_____\",[\"文明交流、文明互鉴、文明优越\"]],[\"中国共产党坚持独立自主的和平外交政策，坚持_____道路，坚持互利共赢的开放战略\",[\"和平发展\"]],[\"中国独立自主的和平外交政策，应当把_____放在第一位\",[\"维护国家主权和安全\"]],[\"中国坚持独立自主的和平外交政策，必须放在第一位的是\",[\"国家主权和安全\"]],[\"推动建立新型国际关系，要在_____原则基础上发展同世界各国的友好合作\",[\"和平共处五项\"]],[\"要按照大国是_____，发展与大国的关系，推动建立新型国际关系\",[\"关键\"]],[\"要按照发展中国家是_____，发展与各国的关系，推动建立新型国际关系\",[\"基础\"]],[\"经济全球化在本质上是\",[\"资本的跨国流动\",\"资本国际循环与周转的形成\"]],[\"中国坚持走和平发展道路的理念是\",[\"和平、发展\",\"开放、合作\",\"和谐、共赢\"]],[\"我们需要的经济全球化应当是世界各国\",[\"平等\",\"互惠\",\"共赢\",\"共存\"]],[\"中国坚持走和平发展道路，是基于_____的必然选择\",[\"中国特色社会主义\",\"中国政治文明发展\",\"中国历史文化传统\",\"当今世界发展潮流\"]],[\"中国和平发展的道路，就是把\",[\"中国国内发展与对外开放统一起来\",\"中国的发展与世界的发展联系起来\",\"中国人民的根本利益与世界人民的共同利益结合起来\"]],[\"促进“一带一路”国际合作，打造政治互信、经济融合、文化包容的\",[\"利益共同体\",\"命运共同体\",\"责任共同体\"]],[\"要把“一带一路”建成\",[\"和平之路\",\"繁荣之路\",\"开放之路\",\"文明之路\"]],[\"和谐世界应该是_____的世界\",[\"民主\",\"和睦\",\"公正\",\"包容\"]],[\"“一带一路”建设，要以_____为主要内容加强合作\",[\"政策沟通\",\"设施联通\",\"贸易畅通\",\"民心相通\"]],[\"构建人类命运共同体思想，其意义有\",[\"反映了全人类共同价值追求\",\"适应了新时代中国与世界关系的历史性变化\",\"成为中国引领时代潮流的鲜明旗帜\",\"成为中国引领人类文明进步方向的鲜明旗帜\"]],[\"推动建设_____的新型国际关系\",[\"相互尊重\",\"公平正义\",\"合作共赢\"]],[\"中国要按照_____理念和外交方针深化同周边国家的关系\",[\"亲诚惠容\",\"与邻为善\",\"以邻为伴\"]],[\"中国秉持_____的全球治理观\",[\"共商\",\"共建\",\"共享\"]],[\"中国奉行独立自主的和平外交政策，意味着\",[\"把国家主权和安全放在第一位\",\"对国际事务，根据事情本身的是非曲直决定我国的立场与政策\",\"世界上的事情应由各国政府和人民平等协商\",\"主张和平解决国际争端\"]],[\"中国走和平发展道路的自信与自觉，来源于\",[\"中华文明的深厚渊源\",\"对实现中国发展目标条件的认知\",\"对世界发展大势的把握\"]],[\"构建人类命运共同体是将中国梦与世界梦有机结合，实现中国与世界共赢的根本途径\",[\"正确\"]],[\"构建新型国际关系是十八大以来习近平提出的重大理念之一，是中国特色大国外交的重要目标之一\",[\"正确\"]],[\"恐怖主义是威胁世界和平与稳定的主要根源\",[\"错误\"]],[\"多极化是促进世界和平与发展的重要基础\",[\"正确\"]],[\"和平是人类发展进步的前提和保证\",[\"正确\"]],[\"我们主张的新型国际关系是要将世界各国纳入一种共同的发展模式上来\",[\"错误\"]],[\"和平共处五项原则只适用于处理我国与社会制度不同国家之间的关系\",[\"错误\"]],[\"独立自主始终是中国外交政策的根本准则\",[\"正确\"]],[\"维护世界和平、促进共同发展是中国外交政策的宗旨\",[\"正确\"]],[\"中国坚持把发展中国家作为对外政策的基础\",[\"正确\"]],[\"中国同俄罗斯发展全面战略协作伙伴关系\",[\"正确\"]],[\"不同国家的文化，只有姹紫嫣红之别，而无高低优劣之分\",[\"正确\"]],[\"中国坚持永远不称霸，永远不搞扩张\",[\"正确\"]],[\"多极化格局有利于遏制霸权主义和强权政治\",[\"正确\"]],[\"多极化格局有利于推动建立公正合理的国际政治经济新秩序\",[\"正确\"]],[\"经济全球化有利于促进资本、技术、知识等生产要素在全球范围内的优化配置\",[\"正确\"]],[\"经济全球化是一把“双刃剑”\",[\"正确\"]],[\"伟大斗争、伟大工程、伟大事业、伟大梦想是一个有机统一的整体，其中，_____是手段\",[\"伟大斗争\"]],[\"伟大斗争、伟大工程、伟大事业、伟大梦想是一个有机统一的整体，其中，_____是目标\",[\"伟大梦想\"]],[\"中国共产党的根本政治制度是\",[\"人民代表大会制度\"]],[\"坚持党的领导，必须努力\",[\"改善党的领导\"]],[\"党的领导地位是\",[\"历史和人民的选择\"]],[\"中国特色社会主义最本质的特征是\",[\"党的领导\"]],[\"把“中国特色社会主义最本质的特征是中国共产党的领导”载入宪法总纲，是在\",[\"十三届全国人大一次会议\"]],[\"中国特色社会主义制度的最大优势，是\",[\"党的领导\"]],[\"全党必须牢固树立政治意识、大局意识、_____和看齐意识\",[\"核心意识\"]],[\"全党必须牢固树立政治意识、大局意识、核心意识和_____\",[\"看齐意识\"]],[\"党政军民学、东西南北中，_____是领导一切的\",[\"党\"]],[\"_____是党的根本组织原则，是党内政治生活正常开展的重要制度保障。\",[\"民主集中制\"]],[\"新时代中国共产党的历史使命是\",[\"实现中华民族伟大复兴\"]],[\"_____是激励全党全国各族人民奋勇前进的强大精神力量\",[\"中国特色社会主义文化\"]],[\"坚决维护党中央权威和集中统一领导，就要严明党的_____和政治规矩，层层落实管党治党政治责任\",[\"政治纪律\"]],[\"马克思主义政党的本质特征是\",[\"立党为公、执政为民\"]],[\"中国共产党作为执政党能长期执政的关键所在是\",[\"保持党同人民群众的血肉联系\"]],[\"决定一个政党心衰的根本因素是\",[\"人心向背\"]],[\"中国共产党的力量之源和胜利之本是\",[\"人民群众\"]],[\"中国共产党的宗旨是\",[\"全心全意为人民服务\"]],[\"中国共产党执政的实质在于\",[\"把人民赋予的权力用来为人民服务\"]],[\"中国共产党的本质特征是\",[\"一切从人民的利益出发、全心全意为人民服务\"]],[\"确保党始终总揽全局、协调各方，必须增强\",[\"政治意识\",\"大局意识\",\"核心意识\",\"看齐意识\"]],[\"新的历史条件下，只有改善党的领导，才能坚持和加强党的领导，这是因为\",[\"当今世界正在发生广泛而深刻的变化，为适应国际环境的变化，必须改善党的领导\",\"当代中国正在发生广泛而深刻的变革，新形势、新任务对我们党提出了新的要求\",\"目前我们党的实际状况同党肩负的领导社会主义现代化的使命有许多不相适应的地方\"]],[\"中国共产党在长期奋斗中形成了下列独特的自身优势\",[\"以马克思主义为指导，用马克思主义中国化最新理论成果武装全党、教育人民的理论优势\",\"坚定崇高的政治理想、政治信念和百折不挠的革命意志的政治优势\",\"坚持民主集中制这一制度优势\",\"密切联系群众的优势\"]],[\"中国共产党把科学社会主义原则和中国实际相结合，创建了_____等基本政治制度\",[\"中国共产党领导的多党合作和政治协商制度\",\"民族区域自治制度\",\"基层群众自治制度\"]],[\"党既要政治过硬，也要本领高强。要增强\",[\"学习本领\",\"政治领导本领\",\"改革创新本领\",\"科学发展本领\"]],[\"党既要政治过硬，也要本领高强。要增强\",[\"依法执政本领\",\"群众工作本领\",\"狠抓落实本领\"]],[\"要加强和改进党对群团工作的领导，推动工会、共青团、妇联等群团组织增强\",[\"政治性\",\"先进性\",\"群众性\",\"娱乐性\"]],[\"党必须着力增强政治领导本领，不断提高\",[\"把方向、谋大局的能力\",\"定政策、促改革的能力\",\"保持政治定力、驾驭政治局面的能力\",\"防范政治风险的能力\"]],[\"党增强政治领导本领，必须坚持_____思维\",[\"战略\",\"创新\",\"法治\",\"底线\"]],[\"坚持民主集中制，意味着\",[\"党的重大决策要严格按照程序办事\",\"党要充分发扬民主，广泛听取意见和建议\",\"党中央从全局出发、集中各方面智慧作出的决定，各地方、各部门要坚决贯彻执行\"]],[\"党中央作出的决策部署，_____等的党组织要贯彻落实\",[\"人大\",\"政府\",\"政协\",\"法院\"]],[\"中央政治局常务委员会听取_____党组汇报，已成为实现党中央集中统一领导的重要制度安排\",[\"全国人大常委会\",\"国务院\",\"最高法院\",\"最高检察院\"]],[\"每一个党的组织、每一名党员干部，必须坚持\",[\"以党的旗帜为旗帜\",\"以党的方向为方向\",\"以党的意志为意志\",\"服从党中央集中统一领导\"]],[\"党的领导要体现和落实到_____等各个方面\",[\"政治建设\",\"社会建设\",\"文化建设\",\"外交\"]],[\"坚持党对一切工作的领导，是\",[\"党领导革命经验的深刻总结\",\"党领导建设经验的深刻总结\",\"党领导改革经验的深刻总结\",\"推进伟大事业的根本保证\"]],[\"中国特色社会主义是改革开放以来党的全部理论和实践的主题\",[\"正确\"]],[\"党政军民学、东西南北中，党是领导一切的\",[\"正确\"]],[\"党是最高政治领导力量\",[\"正确\"]],[\"党的领导地位和执政地位不是与生俱来的，也不是一劳永逸的\",[\"正确\"]],[\"党的领导地位和执政地位，过去拥有不等于现在拥有，现在拥有不等于永远拥有\",[\"正确\"]],[\"依法执政是新的历史条件下党执政的基本方式\",[\"正确\"]],[\"党实行的民主集中制，是民主基础上的集中和集中指导下的民主相结合的制度\",[\"正确\"]],[\"中央委员会、中央政治局、中央政治局常委会，这是党的领导决策核心\",[\"正确\"]],[\"党中央作出的决策部署，人大、政府、政协以及法院、检察院等的党组织要贯彻落实\",[\"正确\"]],[\"党中央作出的决策部署，党的组织、宣传、统战、政法等部门要贯彻落实\",[\"正确\"]],[\"党中央作出的决策部署，各事业单位、人民团体等的党组织要贯彻落实\",[\"正确\"]],[\"“坚持党要管党、全面从严治党”是新时代党的建设的根本方针\",[\"正确\"]],[\"中国共产党的领导地位是历史和人民的选择\",[\"正确\"]],[\"中国共产党是中国工人阶级的先锋队，同时是中国人民和中华民族的先锋队\",[\"正确\"]],[\"党的自身优势是中国特色社会主义制度优势的主要来源\",[\"正确\"]]]}catch(f){}}();";
                try {
                    js = URLEncoder.encode(js, "UTF-8").replaceAll("\\+","%20");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                webview.loadUrl("javascript: "+js);
            }
        });
        String ua = webview.getSettings().getUserAgentString();//原来获取的UA
        webview.getSettings().setUserAgentString(ua+ " agentweb/4.0.2  UCBrowser/11.6.4.950");
        webview.loadUrl("http://mysz.glut.edu.cn/app/");//显示远程网页
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (webview.canGoBack()) {
                webview.goBack();   //后退
                return true;    //已处理
            } else {
                if (isTaskRoot()) {
                    moveTaskToBack(false);
                    return true;
                } else {
                    return super.onKeyDown(keyCode, event);
                }
            }
        }else if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN) {
            webview.loadUrl("javascript: getAuto()");
            return true;
        }else if (keyCode == KeyEvent.KEYCODE_VOLUME_UP) {
            webview.loadUrl("javascript: getAuto2()");
            return true;
        }
        return false;
    }

}
