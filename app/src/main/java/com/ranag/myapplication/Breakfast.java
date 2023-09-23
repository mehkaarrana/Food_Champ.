package com.ranag.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Breakfast extends AppCompatActivity {

    ImageView gohome;
    TextView listbrek;
    Toolbar toolbar;
    RecyclerView recyclerView;
    Adept adept;
    ArrayList<Mdclass> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakfast);
        listbrek=findViewById(R.id.listbrak);
        gohome=findViewById(R.id.gohomebreakfast);
        toolbar=findViewById(R.id.toolbarbreakfast);

        //for banana kheer....
          String[] banana={"2 Cups milk","1 cup mashed banana","Sliced banana, to garnish","1/2 tsp cardamom powder","2 strands kesar (optional)",
          "Jaggery powder, as per taste","Half cup roughly chopped nuts (of your choice)"};

          String[] hindibanana={"2 कप दूध", "1 कप मसला हुआ केला", "कटा हुआ केला, सजाने के लिए", "1/2 छोटा चम्मच इलायची पाउडर", "2 केसर (वैकल्पिक)",
                  "गुड़ पाउडर, स्वादानुसार", "आधा कप मोटे कटे हुए मेवे (अपनी पसंद के अनुसार)"};

          String[] bananahm={"Boil the milk on low-medium flame until it thickens","Add kesar, cardamom powder and dry fruits to it. Simmer until the kesar leaves colour",
          "Take mashed banana in a bowl and add the milk to it","Garnish with sliced banana and serve"};
          String[] hindibananahm={"दूध को धीमी-मध्यम आंच पर गाढ़ा होने तक उबालें", "इसमें केसर, इलायची पाउडर और सूखे मेवे डालें। केसर का रंग छोड़ने तक धीमी आंच पर पकाएं",
                  "एक कटोरे में मैश किया हुआ केला लें और उसमें दूध मिलाएं", "कटे हुए केले से सजाएं और परोसें"};



          //for Butter Garlic Pan-Fried Noodles
        String[] butter={"1 Cup parboiled egg noodles","1-2 tbsp garlic , chopped","1 tbsp spring onion , chopped","1 tsp soy sauce","1 tsp black pepper",
        "Salt, to taste","1 tsp white sesame seeds","1 tbsp butter","1 tbsp butter"};
        String[] hindibutter={"1 कप उबले अंडे नूडल्स","1-2 बड़े चम्मच लहसुन, कटा हुआ","1 बड़ा चम्मच हरा प्याज, कटा हुआ","1 छोटा चम्मच सोया सॉस","1 छोटा चम्मच काली मिर्च",
                "नमक, स्वादानुसार", "1 चम्मच सफेद तिल", "1 बड़ा चम्मच मक्खन", "1 बड़ा चम्मच मक्खन"};

        String[] butterhm={"Heat a wok and add butter and oil to it","Add garlic and saute","To it, add the noodles and mix well",
        "Add soy sauce, pepper and salt and pan fry","Add spring onion and mix","Finally, toast the sesame seeds and garnish the noodles. Serve hot"};
        String[] hindibutterhm={"कढ़ाई गरम करें और उसमें मक्खन और तेल डालें", "लहसुन डालें और भूनें", "इसमें नूडल्स डालें और अच्छी तरह मिलाएँ",
                "सोया सॉस, काली मिर्च और नमक डालें और पैन फ्राई करें", "हरा प्याज़ डालें और मिलाएँ", "अंत में, तिल को टोस्ट करें और नूडल्स को गार्निश करें। गरमागरम परोसें"};



        //for Soya Dal Paratha Recipe..
        String[] soyadal={"1 Cup Atta","1/2 cup mong dal, soaked for 2 hours","soaked soya chunks","A pinch of hing","2 tsp Ghee","1 tsp cumin","Salt, as per taste",
        "1 tsp Red Chilli Powder","1 tsp haldi","1/2 tsp Ajwain","Water, to knead dough"};
        String[] hindisoyadal={"1 कप आटा", "1/2 कप मूंग दाल, 2 घंटे भिगोई हुई", "भिगोया हुआ सोया चंक्स", "एक चुटकी हिंग", "2 चम्मच घी", "1 चम्मच जीरा", "नमक, स्वादानुसार स्वाद",
                "1 चम्मच लाल मिर्च पाउडर", "1 चम्मच हल्दी", "1/2 चम्मच अजवाइन", "पानी, आटा गूंथने के लिए"};

        String[] soyadalhm={"Knead a soft dough with atta, ajwain, salt, some ghee and water","Cover with a cheese cloth and let it rest","Put the soaked moong dal, soaked soya chunks in a blender and make a smooth paste. Add some water if needed",
        "Heat ghee and add a pinch of hing and cumin","Add the blended paste and mix well","Add salt, turmeric powder and red chilli powder and mix until the water is soaked",
        "Now, cut small roundels from the dough, and stuff some soya-dal puree at the centre","Tuck the edges and roll flat","Heat griddle and toast the paratha with ghee",
        "And you have soya-dal paratha ready to be relished.","Serve hot with achar and white butter"};
        String [] hindisoyadalhm={"आटा, अजवाइन, नमक, थोड़ा घी और पानी मिलाकर नरम आटा गूंथ लें", "पनीर के कपड़े से ढककर रख दें", "भिगोई हुई मूंग दाल, भिगोए हुए सोया चंक्स को ब्लेंडर में डालें और एक चिकना पेस्ट बनाएं। यदि आवश्यक हो तो थोड़ा पानी",
                "घी गरम करें और एक चुटकी हींग और जीरा डालें", "मिश्रित पेस्ट डालें और अच्छी तरह मिलाएँ", "नमक, हल्दी पाउडर और लाल मिर्च पाउडर डालें और पानी के भीगने तक मिलाएँ",
                "अब आटे से छोटी-छोटी लोइयां काट लीजिए और बीच में थोड़ी सी सोया-दाल की प्यूरी भर दीजिए", "किनारों को मोड़कर बेल लीजिए", "तवा गर्म कर लीजिए और परांठे को घी में सेक लीजिए",
                "और आपके पास सोया-दाल पराठा खाने के लिए तैयार है।", "आचार और सफेद मक्खन के साथ गरमागरम परोसें"};


        //for paneer sandwitch.
        String[] sandwitch={"For Peri Peri Masala","  2 tbsp Red Chilli Powder","  1/2 tsp Black Salt","  1/4 tsp Cinnamon Powder","  1 tsp Garlic Powder",
                "  1 tsp Ginger Powder","  1 tsp Oregano","  1 tsp Powdered Sugar","  1/2 tsp Salt","For Sandwich Stuffing","  200 gram Paneer","  1/4 cup Capsicum, finely chopped",
        "  1/2 cup Onion , chopped","  1/4 cup Tomato, chopped","  2 tbsp Mayonnaise","  1/2 tsp Chilli Flakes","  1/2 tsp Black Pepper(optional)",
       "  to taste Salt","  4 Bread Slice"};

        String [] hindisandwitch={"पेरी पेरी मसाला के लिए"," 2 बड़े चम्मच लाल मिर्च पाउडर"," 1/2 छोटा चम्मच काला नमक"," 1/4 छोटा चम्मच दालचीनी पाउडर"," 1 छोटा चम्मच लहसुन पाउडर",
                " 1 चम्मच अदरक पाउडर"," 1 चम्मच अजवायन"," 1 चम्मच पीसी हुई चीनी"," 1/2 चम्मच नमक","सैंडविच स्टफिंग के लिए"," 200 ग्राम पनीर"," 1/4 कप शिमला मिर्च, बारीक कटी हुई" ,
                " 1/2 कप प्याज, कटा हुआ"," 1/4 कप टमाटर, कटा हुआ"," 2 बड़े चम्मच मेयोनेज़"," 1/2 छोटा चम्मच चिली फ्लेक्स"," 1/2 छोटा चम्मच काली मिर्च(वैकल्पिक)",
                " स्वादानुसार नमक"," 4 ब्रेड स्लाइस"};

        String[] sandwitchhm={"For Peri Peri Masala ---  Put all the things in the jar, close the lid, Shake well. Your homemade peri peri masala is ready",
        "For Sandwich ---  Put capsicum, onion, tomato and mayonnaise in a bowl","Add chilli flakes, salt as per taste and add peri peri masala and mix everything well",
        "Cut the paneer into small pieces and add it to the mixture. If you want, you can also add some cheese or chili garlic sauce here",
        "Apply butter on a bread slice and spread the stuffing on it and cover it with another bread slice",
        "Grill the sandwich and serve hot"};
        String[] hindisandwitchhm={"पेरी पेरी मसाला के लिए---सारी चीजें जार में डालें, ढक्कन बंद करें, अच्छी तरह हिलाएं। आपका घर का बना पेरी पेरी मसाला तैयार है",
                "सैंडविच के लिए---एक बाउल में शिमला मिर्च, प्याज, टमाटर और मेयोनेज़ डालें", "चिली फ्लेक्स, स्वादानुसार नमक डालें और पेरी पेरी मसाला डालें और सब कुछ अच्छी तरह मिलाएँ",
                "पनीर को छोटे-छोटे टुकड़ों में काट कर मिश्रण में मिला दीजिये. आप चाहें तो यहां थोड़ा पनीर या चिली गार्लिक सॉस भी डाल सकते हैं",
                "ब्रेड स्लाइस पर मक्खन लगाएं और उस पर स्टफिंग फैलाएं और दूसरे ब्रेड स्लाइस से ढक दें",
                "सैंडविच को ग्रिल करें और गरमागरम परोसें"};


        //for Moong Dal Toast...
        String[] moongdal={"1 Cup Moong Dal(Soaked)","1/2 Onion, finely chopped","1/4 cup Carrot, grated","1/4 cup Capsicum, grated","2 Green Chillies",
        "1 Inch Ginger","1 tbsp Ghee","4 Bread Slice","1/2 tsp Red chilli powder","1/2 tsp Coriander powder","1/4 tsp turmeric","to taste Salt",
        "1 tbsp Coriander leaves, finely chopped"};
        String[] hindimoongdal={"1 कप मूंग दाल (भिगोई हुई)","1/2 प्याज, बारीक कटा हुआ","1/4 कप गाजर, कसा हुआ","1/4 कप शिमला मिर्च, कसा हुआ","2 हरी मिर्च",
                "1 इंच अदरक", "1 बड़ा चम्मच घी", "4 ब्रेड स्लाइस", "1/2 छोटा चम्मच लाल मिर्च पाउडर", "1/2 छोटा चम्मच धनिया पाउडर", "1/4 छोटा चम्मच हल्दी", "स्वादानुसार नमक" ,
                "1 बड़ा चम्मच धनिया पत्ती, बारीक कटी हुई"};

        String[] moongdalhm={"Put moong dal, green chillies and ginger in a grinding jar and make a smooth batter by grinding them","Add asafoetida, onion, capsicum, carrot, red chili, turmeric, coriander powder and salt to the batter and mix everything well",
        "Heat a pan by placing it on the gas, now take a bread slice and spread the batter on one side of it","Spread a little ghee on a hot pan and place the toast on it, now spread the batter on the other side as well",
        "Put a little ghee on it and roast it till it becomes crispy from the other side as well",
                "When the toast gets roasted well from both the sides, cut it and serve it with chutney"};
        String[] hindimoongdalhm={"मूंग दाल, हरी मिर्च और अदरक को ग्राइंडिंग जार में डालें और पीसकर चिकना घोल बना लें", "बैटर में हींग, प्याज, शिमला मिर्च, गाजर, लाल मिर्च, हल्दी, धनिया पाउडर और नमक डालें और सभी चीजों को अच्छे से मिला लें" ,
                "एक पैन को गैस पर रखकर गर्म करें, अब एक ब्रेड स्लाइस लें और उसके एक तरफ बैटर फैलाएं", "गर्म पैन पर थोड़ा सा घी फैलाएं और उस पर टोस्ट रखें, अब दूसरी तरफ बैटर फैलाएं ओर भी",
                "इसके ऊपर थोड़ा सा घी डालकर इसे दूसरी तरफ से भी कुरकुरा होने तक भून लीजिए",
                "जब टोस्ट दोनों तरफ से अच्छे से सिक जाए तो इसे काट लें और चटनी के साथ परोसें"};



        //for Paneer Roastie Recipe
        String[] paneer={"1 Cup Suji","1 cup Curd","1/4 cup Capsicum, finely chopped","1/4 cup Onion, finely chopped","1-inch Ginger, finely chopped"
        ,"1 tsp Garlic, finely chopped","2 Green Chillies, finely chopped","1/4 cup Carrot, finely chopped","1/4 cup Beans, finely chopped","150 gram Paneer, grated",
        "1 tsp Chilli flakes","1/2 tsp Coriander Powder","1/2 tsp Black Pepper Powwder","to taste Salt","2 tbsp Oil","2 tbsp Coriander Leaves, finely chopped",
        "1/2 tsp Jeera","A pinch of Hing","1/4 tsp Turmeric","7-8 Currt Leaves","1 tsp Mustard Seeds","11/2 cup Water","1 Pack Fruit Salt"};
        String [] hindipaneer={"1 कप सूजी", "1 कप दही", "1/4 कप शिमला मिर्च, बारीक कटी", "1/4 कप प्याज, बारीक कटी", "1 इंच अदरक, बारीक कटी"
                ,"1 चम्मच लहसुन, बारीक कटा हुआ", "2 हरी मिर्च, बारीक कटी", "1/4 कप गाजर, बारीक कटी", "1/4 कप बीन्स, बारीक कटी", "150 ग्राम पनीर, कसा हुआ",
                "1 छोटा चम्मच चिली फ्लेक्स", "1/2 छोटा चम्मच धनिया पाउडर", "1/2 छोटा चम्मच काली मिर्च पाउडर", "स्वादानुसार नमक", "2 बड़े चम्मच तेल", "2 बड़े चम्मच हरा धनिया, बारीक कटा हुआ",
                "1/2 चम्मच जीरा", "एक चुटकी हींग", "1/4 चम्मच हल्दी", "7-8 करी पत्ता", "1 चम्मच सरसों के बीज", "11/2 कप पानी", "1 पैक फल नमक"};

        String [] paneerhm={"Add one cup semolina, curd and 1 cup water in a bowl and mix well. Keep this batter aside","Heat one tablespoon oil in a pan and add mustard seeds, cumin seeds and curry leaves and let them crackle for a few seconds","Add onion, green chili, ginger, garlic to it and saute it for few seconds. Now, put capsicum, beans and carrots in it and let it cook",
        "Add chili flakes, black pepper powder, salt and coriander powder and fry for a few seconds. Now add grated paneer to it and mix it well with the spices and fry it. Let it cool down",
        "Add some water to the batter and mix the paneer mixture in it. Add fruit salt to it and mix","Now put a little oil in a pan and take ladle full batter and spread it in the pan and cover it with a lid and roast it from one side. Similarly, roast from the other side as well",
        "Your paneer rostie is ready, serve it with green chutney"};
        String [] hindipannehm={"एक कटोरे में एक कप सूजी, दही और 1 कप पानी डालें और अच्छी तरह मिलाएँ। इस घोल को एक तरफ रख दें", "एक पैन में एक बड़ा चम्मच तेल गरम करें और उसमें राई, जीरा और करी पत्ता डालें और उन्हें कुछ सेकंड के लिए चटकने दें। ","इसमें प्याज, हरी मिर्च, अदरक, लहसुन डालें और कुछ सेकेंड तक भूनें. अब इसमें शिमला मिर्च, बीन्स और गाजर डालें और पकने दें",
                "चिली फ्लेक्स, काली मिर्च पाउडर, नमक और धनिया पाउडर डालकर कुछ सेकेंड तक भूनें. अब इसमें कद्दूकस किया हुआ पनीर डालें और मसाले के साथ अच्छे से मिलाकर भून लें. इसे ठंडा होने दें",
                "बैटर में थोड़ा सा पानी डालें और इसमें पनीर का मिश्रण मिलाएं। इसमें फ्रूट सॉल्ट डालें और मिक्स करें", "अब एक पैन में थोड़ा सा तेल डालें और कलछी भर बैटर लें और इसे पैन में फैलाएं और ढक्कन से ढक दें। और एक तरफ से भी सेक लीजिए. इसी तरह से दूसरी तरफ से भी सेक लीजिए.",
                "आपकी पनीर रोस्टी तैयार है, इसे हरी चटनी के साथ परोसें"};


        //for Masala French Toast Recipe...
        String[] masala={"2 Eggs","6 tbsp Milk","1/2 tsp Salt","1/2 tsp Red chilli powder (or more if you can take the heat)","1/4 tsp Black pepper powder",
        "1 Small tomato","1 Small onion","2-3 Green chillies (or as per your spice threshold)","A few sprigs of cilantro leaves (dhaniya)","Chaat masala to sprinkle"
        ,"Butter to pan fry (you can use oil as well)"};
        String[] hindimasala={"2 अंडे","6 बड़े चम्मच दूध","1/2 छोटा चम्मच नमक","1/2 छोटा चम्मच लाल मिर्च पाउडर (या अधिक अगर आप गर्मी सह सकते हैं)","1/4 छोटा चम्मच काली मिर्च पाउडर",
                "1 छोटा टमाटर", "1 छोटा प्याज", "2-3 हरी मिर्च (या आपके मसाले के अनुसार)", "धनिया की कुछ टहनी", "चाट मसाला छिड़कने के लिए",
                "तलने के लिए मक्खन (आप तेल का भी उपयोग कर सकते हैं)"};

        String[] masalahm={"First, finely chop green chillies, cilantro sprigs, onion and tomato. Mix well and keep it aside","Now, cut the bread slices into half, diagonally. You'll end up with 8 triangles. (You can also make them rectangle, square, smaller or bigger)",
        "Crack the eggs in a mixing bowl. While beating the eggs, add milk, salt, red chilli powder and black pepper powder. Mix well","Melt a little butter in a skillet set on medium-high heat. Parallelly dip two of the bread slices in the egg-milk mixture, carefully flipping it once with your hands",
        "Once both the sides are coated, lift them out and place them on the hot skillet","Once both the sides are done, lift them out and place them on a wire cooling rack or a plate lined with kitchen paper towels",
        "Continue to dip, soak and fry the remaining bread in batches until all of them are done",
         "Once all of them are done, arrange on a plate and top them with a generous helping of the onion-tomato masala and a sprinkle of chaat masala. Masala French Toast is ready!"};
        String[] hindimasalahm={"सबसे पहले, हरी मिर्च, सीताफल की टहनी, प्याज और टमाटर को बारीक काट लें। अच्छी तरह मिलाएं और एक तरफ रख दें", "अब, ब्रेड स्लाइस को तिरछे आधे हिस्से में काट लें। आपके पास 8 त्रिकोण होंगे। (आप इन्हें भी बना सकते हैं) आयत, वर्गाकार, छोटा या बड़ा)",
                "अंडों को मिक्सिंग बाउल में फोड़ लें। अंडे फेंटते समय, दूध, नमक, लाल मिर्च पाउडर और काली मिर्च पाउडर डालें। अच्छी तरह मिलाएं", "मध्यम-उच्च गर्मी पर एक कड़ाही में थोड़ा मक्खन पिघलाएं। समानांतर रूप से दो मक्खन डुबोएं ब्रेड स्लाइस को अंडे-दूध के मिश्रण में डालें, ध्यान से इसे एक बार अपने हाथों से पलटें",
                "एक बार जब दोनों तरफ से कोटिंग हो जाए, तो उन्हें उठाएं और गर्म तवे पर रखें", "एक बार जब दोनों तरफ से कवर हो जाए, तो उन्हें उठाएं और उन्हें वायर कूलिंग रैक या किचन पेपर टॉवल से ढकी प्लेट पर रखें",
                "बची हुई ब्रेड को बैचों में डुबाना, भिगोना और भूनना जारी रखें जब तक कि वे पक न जाएं",
                "एक बार जब ये सब पक जाएं, तो इन्हें एक प्लेट में रखें और इनके ऊपर प्याज-टमाटर का मसाला और चाट मसाला छिड़कें। मसाला फ्रेंच टोस्ट तैयार है!"};






        recyclerView=findViewById(R.id.recycleOfbreakfast);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        arrayList=new ArrayList<>();
        arrayList.add(new Mdclass(R.drawable.bananakheer,"dTUJSYkxQGY","Banana Kheer Recipe","केले की खीर रेसिपी","20 ","This banana kheer is a delicious recipe, which is not fulfill your dessert cravings, you can also have it in your breakfast.","यह केले की खीर एक स्वादिष्ट रेसिपी है, जो आपकी मिठाई खाने की इच्छा को पूरा नहीं करती है, आप इसे अपने नाश्ते में भी खा सकते हैं.",
                banana,hindibanana,bananahm,hindibananahm));
        arrayList.add(new Mdclass(R.drawable.butternoodles,"pBKplRz5HQs","Butter Garlic Pan-Fried Noodles","मक्खन लहसुन पैन-फ्राइड नूडल्स","25 ","This is a quick and easy noodle recipe, cooked with garlic and light spices. This recipe will hit between all-age groups.","यह एक त्वरित और आसान नूडल रेसिपी है, जिसे लहसुन और हल्के मसालों के साथ पकाया जाता है। यह रेसिपी हर उम्र के लोगों के बीच काम आएगी.",
                butter,hindibutter,butterhm,hindibutterhm));
        arrayList.add(new Mdclass(R.drawable.soyadalparatha,"-_waDvH-l4Q","Soya Dal Paratha Recipe","सोया दाल पराठा","20 ","Soya and pulses both are protein rich foods. Including them in the diet in any form is very healthy for health. Besides, it is also easy to make. So let us quickly know how to make the recipe of Soya Dal Paratha.","सोया और दाल ये दोनों ही प्रोटीन रिच फूड्स हैं। इन्हें डाइट में किसी भी रूप में शामिल करना सेहत के लिए बेहद ही हेल्दी होता है। साथ ही इसे बनाना भी आसान है। तो आइए जल्दी से जान लेते है सोया दाल पराठा की रेसिपी कैसे बनाई जाती है।",
                soyadal,hindisoyadal,soyadalhm,hindisoyadalhm));
        arrayList.add(new Mdclass(R.drawable.sandwich,"XCJzGU6qjWE","Peri Peri Paneer Sandwich Recipe","पेरी पेरी पनीर सैंडविच रेसिपी","30 ","We all are big fan of peri peri fries but do you know we can make a delicious peri peri paneer sandwich for a quick and easy breakfast.","हम सभी पेरी पेरी फ्राइज़ के बहुत बड़े प्रशंसक हैं, लेकिन क्या आप जानते हैं कि हम त्वरित और आसान नाश्ते के लिए स्वादिष्ट पेरी पेरी पनीर सैंडविच बना सकते हैं।",
                sandwitch,hindisandwitch,sandwitchhm,hindisandwitchhm));
        arrayList.add(new Mdclass(R.drawable.moonddaltoast,"XCrrOAWnJ50","Moong Dal Toast Recipe","मूंग दाल टोस्ट रेसिपी","15 ","Moong Dal Toast is a very healthy and tasty recipe that you can make in few minutes for breakfast or evening snack. Not only this, it is also a good and tasty option for children's tiffin.","मूंग दाल टोस्ट एक बहुत ही हेल्दी और स्वादिष्ट रेसिपी है जिसे आप नाश्ते या शाम के नाश्ते के लिए कुछ ही मिनटों में बना सकते हैं. इतना ही नहीं यह बच्चों के टिफिन के लिए भी एक अच्छा और स्वादिष्ट विकल्प है.",
                moongdal,hindimoongdal,moongdalhm,hindimoongdalhm));
        arrayList.add(new Mdclass(R.drawable.paneerroastie,"zn4S_x0EQ94","Paneer Roastie Recipe","पनीर रोस्टी रेसिपी","25 ","This is a quick and healthy breakfast recipe which is made with suji, dahi, paneer and some veggies. It is can be a perfect addition in for protein rich breakfast.","यह एक त्वरित और स्वस्थ नाश्ता रेसिपी है जो सूजी, दही, पनीर और कुछ सब्जियों के साथ बनाई जाती है। यह प्रोटीन युक्त नाश्ते के लिए एक आदर्श अतिरिक्त हो सकता है।",
                paneer,hindipaneer,paneerhm,hindipannehm));
        arrayList.add(new Mdclass(R.drawable.masalafrench,"F0avwHblzxs","Masala French Toast Recipe","मसाला फ्रेंच टोस्ट रेसिपी","25 ","This masala French toast is spicy, crunchy and all things delicious! Serve it with ketchup or green dhaniya-pudina chutney to relish its taste.","यह मसाला फ्रेंच टोस्ट मसालेदार, कुरकुरा और हर चीज में स्वादिष्ट है! इसका स्वाद चखने के लिए इसे केचप या हरी धनिया-पुदीना चटनी के साथ परोसें।",
                masala,hindimasala,masalahm,hindimasalahm));




        adept=new Adept(this,arrayList);
        recyclerView.setAdapter(adept);

        SharedPreferences sharedPreferences=getSharedPreferences("language",MODE_PRIVATE);
        boolean res=sharedPreferences.getBoolean("type",false);
        if(res){
            listbrek.setText("नाश्ते की सूची");
            adept.notifyDataSetChanged();
            toolbar.setTitle("नाश्ता भोजन");
        }else {
            listbrek.setText("List of Breakfast Recipes");
            adept.notifyDataSetChanged();
            toolbar.setTitle("Breakfast Recipes");

        }
        gohome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Breakfast.this,MainActivity.class));
            }
        });


    }
}