package com.ranag.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class VegFood extends AppCompatActivity {

    ArrayList<Mdclass> arrayList;
    Adept adept;
    RecyclerView recyclerView;
    Toolbar toolbar;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veg_food);
        textView=findViewById(R.id.listveg);



        toolbar=findViewById(R.id.toolbarveg);
        setSupportActionBar(toolbar);
        arrayList=new ArrayList<>();
        String arrhm[]={"Sieve the besan for the kadhi into a large mixing bowl. Add the sour curds and churn well","Add two cups of water, haldi, chilli powder, dhania powder, hing and salt. Mix well to get a smooth, runny batter-like consistency",
        "In a kadhai, heat ghee and add mustard seeds, cumin seeds and whole spices (bay leaves, cloves, etc., as listed above)",
        "Next, add the ginger, curry leaves and green chillies. Saute on low flame for a minute","Now, add the prepared besan mixture to the kadhai, while stirring continuously. Pour 2 cups of water and mix well on medium flame",
        "Continue to stir until the mixture starts boiling. Then turn the heat to low again. Let it cook, uncovered, for another 5-10 minutes",
        "In the meantime, start preparing the pakoras. To do so, combine the besan with the rest of the ingredients listed above. Crush the ajwain (carom seeds) with your palm before adding",
        "Add 2 tbsp of water to this besan mixture to form a thick batter. Using a teaspoon, take small portions of the batter and pop them into the hot oil. Set aside",
        "Add these pakoras to the kadhi and mix well","Prepare a tadka (tempering) by heating ghee and adding garlic. Stir for a few seconds and then add red chillies and chilli powder. Immediately, add 1 tbsp of water to this tadka. Pour it over the kadhi and turn off the stove",
        "Garnish the Rajasthani kadhi pakora with chopped coriander leaves. Serve hot"};

        String hindiarrhm[]={"कढ़ी के लिए बेसन को एक बड़े कटोरे में छान लें। खट्टा दही डालें और अच्छी तरह से मथ लें", "दो कप पानी, हल्दी, मिर्च पाउडर, धनिया पाउडर, हींग और नमक डालें। एक चिकना, पतला घोल बनाने के लिए अच्छी तरह मिलाएं। -जैसी स्थिरता",
                "एक कढ़ाई में घी गर्म करें और उसमें राई, जीरा और साबुत मसाले (तेजपत्ता, लौंग आदि, जैसा कि ऊपर सूचीबद्ध है) डालें",
                "इसके बाद, अदरक, करी पत्ता और हरी मिर्च डालें। एक मिनट के लिए धीमी आंच पर भूनें", "अब, लगातार हिलाते हुए, तैयार बेसन मिश्रण को कढ़ाई में डालें। 2 कप पानी डालें और मध्यम आंच पर अच्छी तरह मिलाएं" ,
                "मिश्रण में उबाल आने तक हिलाते रहें। फिर आँच को फिर से कम कर दें। इसे बिना ढके, 5-10 मिनट तक पकने दें",
                "इस बीच, पकोड़े तैयार करना शुरू करें। ऐसा करने के लिए, बेसन को ऊपर सूचीबद्ध बाकी सामग्री के साथ मिलाएं। जोड़ने से पहले अजवाइन को अपनी हथेली से कुचल लें",
                "बेसन के इस मिश्रण में 2 बड़े चम्मच पानी डालकर गाढ़ा घोल बना लें। एक चम्मच का उपयोग करके, घोल के छोटे-छोटे हिस्से लें और उन्हें गर्म तेल में डालें। एक तरफ रख दें",
                "इन पकौड़ों को कढ़ी में डालें और अच्छी तरह मिलाएँ", "घी गर्म करके और लहसुन डालकर तड़का तैयार करें। कुछ सेकंड तक हिलाएँ और फिर लाल मिर्च और मिर्च पाउडर डालें। तुरंत, इस तड़के में 1 बड़ा चम्मच पानी डालें . इसे कढ़ी के ऊपर डालें और स्टोव बंद कर दें",
                "राजस्थानी कढ़ी पकौड़े को कटी हुई हरी धनिया से सजाएं। गरमागरम परोसें।"};

        String acharihm[]={"Start by heating oil in a kadhai set on a low-medium flame. To this, add jeera, nigella (kalonji) seeds, black peppercorns, bay leaves, and fennel seeds. Once the seeds start to splutter, add red chilli powder and haldi. Mix well and add curd",
        "Next, add the lemon pickle along with salt and saute for a minute or two. Add the rice, paneer cubes, and chopped bell peppers. Toss the mixture really well, and then add 3 cups of water to it. You can add more if required",
        "Allow the rice mixture to boil over a low-medium flame until the water is fully absorbed by the rice",
        "Once done, garnish with fresh coriander leaves and serve hot. Your achaari paneer pulao is ready to be relished"};

        String hindiacharihm[]={"धीमी-मध्यम आंच पर एक कढ़ाई में तेल गर्म करके शुरू करें। इसमें जीरा, कलौंजी के बीज, काली मिर्च, तेजपत्ता और सौंफ डालें। जब बीज चटकने लगें तो लाल मिर्च पाउडर डालें और डालें। हल्दी, अच्छी तरह मिलाएं और दही डालें",
                "इसके बाद, नमक के साथ नींबू का अचार डालें और एक या दो मिनट तक भूनें। चावल, पनीर के टुकड़े और कटी हुई शिमला मिर्च डालें। मिश्रण को अच्छी तरह से हिलाएँ, और फिर इसमें 3 कप पानी डालें। आप और भी डाल सकते हैं यदि आवश्यक हुआ",
                "चावल के मिश्रण को धीमी-मध्यम आंच पर तब तक उबलने दें जब तक पानी पूरी तरह से चावल द्वारा अवशोषित न हो जाए",
                "एक बार हो जाने पर, ताजी हरी धनिया से सजाएं और गरमागरम परोसें। आपका अचारी पनीर पुलाव खाने के लिए तैयार है।"};

        String chanadalhm[]={"Start by preparing the dough for the kachori. For this, add maida, baking soda, salt, oil, and water to a bowl and mix well. Form a smooth dough and cover it with a wet cloth. Keep it aside for half an hour",
        "In the meantime, transfer the chana dal to a mixer grinder to grind it coarsely. You can also add some water if required",
        "To prepare the kachori filling, heat ghee in a pan. Add green chillies, ginger, and cashew nuts. Saute for a few minutes, and then add all the dry masalas, including red chilli powder, garam masala, chaat masala, hing, and dhania powder. Mix well and cook for around 5-7 minutes",
        "Once done, remove from the heat and add lemon juice. Keep the mixture aside and allow it to cool",
        "Now, heat oil in a kadhai. Divide the dough into equal portions and stuff each one with the prepared filling, shaping them into balls",
        "Slowly add them to the oil and deep-fry until they become golden brown and crispy. Your chana dal kachoris are ready to be relished"};

        String hindichanadalhm[]={"कचौरी के लिए आटा तैयार करने से शुरुआत करें. इसके लिए एक बाउल में मैदा, बेकिंग सोडा, नमक, तेल और पानी डालकर अच्छी तरह मिला लें. चिकना आटा गूंथ लें और इसे गीले कपड़े से ढक दें. इसे आधे घंटे के लिए अलग रख दें घंटा",
                "इस बीच, चना दाल को मिक्सर ग्राइंडर में डालकर दरदरा पीस लें। यदि आवश्यक हो तो आप थोड़ा पानी भी मिला सकते हैं।",
                "कचौरी का भरावन तैयार करने के लिए, एक पैन में घी गर्म करें। इसमें हरी मिर्च, अदरक और काजू डालें। कुछ मिनट तक भूनें, और फिर लाल मिर्च पाउडर, गरम मसाला, चाट मसाला, हींग सहित सभी सूखे मसाले डालें। और धनिया पाउडर। अच्छी तरह मिलाएं और लगभग 5-7 मिनट तक पकाएं",
                "एक बार हो जाने पर, आंच से उतार लें और नींबू का रस डालें। मिश्रण को एक तरफ रख दें और ठंडा होने दें",
                "अब, एक कढ़ाई में तेल गरम करें। आटे को बराबर भागों में बाँट लें और प्रत्येक भाग में तैयार भरावन भरें, उन्हें गोले का आकार दें",
                "उन्हें धीरे-धीरे तेल में डालें और सुनहरा भूरा और कुरकुरा होने तक तलें। आपकी चना दाल की कचौरियां खाने के लिए तैयार हैं।"};

        String cholehm[]={"Soak the chickpeas and dal overnight or for at least 6-8 hours in plenty of water. Rinse them thoroughly before cooking",
        "In a pressure cooker, add the soaked chickpeas and dal, enough water to cover them, and a pinch of salt. Cook until the chickpeas are soft",
        "Drain the cooked chickpeas and dal and set them aside",
        "Heat the cooking oil in a large pan or pot over medium heat. Add the cumin seeds and let them sizzle for a few seconds",
        "Add the finely chopped onions and saute until they turn golden brown",
        "Stir in the minced garlic, grated ginger, and green chilies. Saute for a couple of minutes until the raw smell disappears",
        "Add the finely chopped tomatoes and cook until they become soft and the oil starts to separate from the mixture",
        "Add the spices and salt. Mix well and cook for a few minutes until the spices are aromatic","Add the cooked chickpeas and dal and mix them with the spicy tomato mixture. Allow the chickpeas to simmer in the gravy for about 10-15 minutes. Add some water if the gravy becomes too thick",
        "Once the chickpeas are well-cooked and the gravy has thickened, your Peshawari Chole is ready to be served",
        "Garnish with fresh coriander leaves, sliced onion and lemon wedges"};

        String hindicholehm[]={"चने और दाल को रात भर या कम से कम 6-8 घंटे के लिए खूब पानी में भिगो दें। पकाने से पहले उन्हें अच्छी तरह धो लें",
                "एक प्रेशर कुकर में भीगे हुए चने और दाल, उन्हें ढकने के लिए पर्याप्त पानी और एक चुटकी नमक डालें। चने के नरम होने तक पकाएं",
                "पके हुए चने और दाल को छान कर अलग रख लें",
                "एक बड़े पैन या बर्तन में मध्यम आंच पर खाना पकाने का तेल गरम करें। इसमें जीरा डालें और उन्हें कुछ सेकंड के लिए तड़कने दें",
                "बारीक कटा हुआ प्याज डालें और सुनहरा भूरा होने तक भूनें",
                "कीमा बनाया हुआ लहसुन, कसा हुआ अदरक और हरी मिर्च डालें। कुछ मिनट तक भूनें जब तक कि कच्ची गंध गायब न हो जाए",
                "बारीक कटे टमाटर डालें और तब तक पकाएं जब तक वे नरम न हो जाएं और मिश्रण से तेल अलग न होने लगे",
                "मसाले और नमक डालें। अच्छी तरह मिलाएँ और कुछ मिनट तक पकाएँ जब तक कि मसालों से खुशबू न आने लगे", "पके हुए चने और दाल डालें और मसालेदार टमाटर के मिश्रण के साथ मिलाएँ। छोले को ग्रेवी में लगभग 10- तक उबलने दें। 15 मिनट, अगर ग्रेवी ज्यादा गाढ़ी हो जाए तो थोड़ा पानी डालें।",
                "एक बार जब चने अच्छी तरह से पक जाएं और ग्रेवी गाढ़ी हो जाए, तो आपके पेशावरी छोले परोसने के लिए तैयार हैं",
                "ताजा हरा धनिया, कटा हुआ प्याज और नींबू के टुकड़ों से सजाएं"};

        String bangalihm[]={"Start by cutting the potatoes and tomatoes into roughly chopped cubes. Now, mix red chilli powder and haldi with some water to make a paste",
        "Heat oil in a pan and add the potatoes. Fry them until they turn golden brown in colour. In the same pan, add the chana (cottage cheese) and fry it too",
        "In the remaining oil, add dried red chilies, bay leaves, and cumin seeds. Saute for a minute or two, and then add the chopped tomatoes",
        "Now, add ginger-garlic paste, cumin powder, and the prepared red chilli powder and haldi paste. Mix well and add sugar, salt, and water. Cook until the oil starts to separate from the mixture",
        "Next, add the fried potatoes and chana to the mixture, cover the pan with a lid, and cook on a medium flame for 10–15 minutes. Finally, add garam masala and ghee to the gravy and give it a nice mix. Bengali chanar dalna is ready to be relished"};

        String hindibangalihm[]={"आलू और टमाटर को मोटे क्यूब्स में काटकर शुरुआत करें। अब, लाल मिर्च पाउडर और हल्दी को थोड़े से पानी के साथ मिलाकर पेस्ट बना लें",
                "एक पैन में तेल गर्म करें और उसमें आलू डालें। आलू को सुनहरा भूरा होने तक भूनें। उसी पैन में चना डालें और उसे भी भून लें।",
                "बचे हुए तेल में सूखी लाल मिर्च, तेजपत्ता और जीरा डालें। एक या दो मिनट तक भूनें, और फिर कटे हुए टमाटर डालें",
                "अब, अदरक-लहसुन का पेस्ट, जीरा पाउडर और तैयार लाल मिर्च पाउडर और हल्दी पेस्ट डालें। अच्छी तरह मिलाएं और चीनी, नमक और पानी डालें। तब तक पकाएं जब तक मिश्रण से तेल अलग न होने लगे",
                "इसके बाद, मिश्रण में तले हुए आलू और चने डालें, पैन को ढक्कन से ढक दें और मध्यम आंच पर 10-15 मिनट तक पकाएं। अंत में, ग्रेवी में गरम मसाला और घी डालें और इसे एक अच्छा मिश्रण दें। बंगाली चनर दलना स्वाद लेने के लिए तैयार है"};


        String cheesyhm[]={"Fill a large pot with water and bring it to a boil. Add a pinch of salt to the boiling water","Cook the pasta according to the package instructions until it's al dente. Drain the pasta and set it aside",
        "Heat the olive oil in a large skillet over medium-high heat","Add your assorted vegetables to the skillet. Season with a pinch of salt and pepper",
        "Saute the veggies until they become slightly tender. Transfer the sauteed vegetables to a plate and keep them warm","In the same skillet you used for the veggies, melt the butter over medium heat",
        "Add the all-purpose flour. Stir constantly for about 1-2 minutes to create a smooth paste","Gradually pour in the milk, whisking continuously to prevent lumps",
        "Continue to cook and whisk until the mixture thickens. This should take about 5-7 minutes","Add the shredded cheese to the creamy sauce, a little at a time, and stir until the cheese is fully melted",
        "Return the cooked pasta to the pan, and toss until it's well-coated in the creamy cheese sauce","Add the sauteed vegetables to the pasta and mix them. Taste the dish and adjust the seasoning with salt and pepper, if needed",
        "Sprinkle some extra shredded cheese and serve"};

        String hindicheesyhm[]={"एक बड़े बर्तन में पानी भरें और इसे उबालें। उबलते पानी में एक चुटकी नमक डालें", "पास्ता को पैकेज के निर्देशों के अनुसार तब तक पकाएं जब तक कि यह अल डेंटे न हो जाए। पास्ता को छान लें और एक तरफ रख दें",
                "मध्यम-तेज आंच पर एक बड़े कड़ाही में जैतून का तेल गर्म करें", "अपनी मिश्रित सब्जियां कड़ाही में डालें। चुटकी भर नमक और काली मिर्च डालें",
                "सब्जियों को हल्का नरम होने तक भूनें। भुनी हुई सब्जियों को एक प्लेट में निकाल लें और गर्म होने के लिए रख दें", "जिस कड़ाही में आपने सब्जियों के लिए इस्तेमाल किया था, उसी कड़ाही में मध्यम आंच पर मक्खन पिघलाएं",
                "मैदा डालें। चिकना पेस्ट बनाने के लिए लगभग 1-2 मिनट तक लगातार हिलाएँ", "धीरे-धीरे दूध डालें, लगातार चलाते रहें ताकि गुठलियाँ न बनें",
                "मिश्रण के गाढ़ा होने तक पकाते और फेंटते रहें। इसमें लगभग 5-7 मिनट का समय लगना चाहिए", "कसी हुई पनीर को क्रीमी सॉस में थोड़ा-थोड़ा करके डालें, और तब तक हिलाएं जब तक कि पनीर पूरी तरह से पिघल न जाए",
                "पकाए हुए पास्ता को पैन में लौटाएं, और तब तक टॉस करें जब तक यह क्रीमी चीज़ सॉस में अच्छी तरह से लिपट न जाए", "पास्ता में भुनी हुई सब्जियां डालें और उन्हें मिलाएं। डिश को चखें और यदि आवश्यक हो तो नमक और काली मिर्च के साथ मसाला समायोजित करें" ,
                "कुछ अतिरिक्त कसा हुआ पनीर छिड़कें और परोसें"};

        String ricerotihm[]={"To begin with, add the rice to a bowl. Add atta, chopped onions, green chillies, coriander leaves, curd, red chilli powder, chaat masala, garam masala, and salt. Mix well",
        "Shape the mixture into a dough as you normally would. If you feel the rice grains are too long, you can even mash them a little before you mix them with the rest of the ingredients. But we suggest you use them as they are for a crunchier bite",
        "Now, take a small portion of the dough and roll it out evenly using a rolling pin","Heat a tawa set on a low-medium flame. Apply some oil over it and place the prepared rotla on it",
        "Cook until golden brown and crispy. Flip and cook the other side, and your rice rotla is ready to be relished"};

        String hindiricerotihm[]={"सबसे पहले, चावल को एक कटोरे में डालें। आटा, कटा हुआ प्याज, हरी मिर्च, हरा धनिया, दही, लाल मिर्च पाउडर, चाट मसाला, गरम मसाला और नमक डालें। अच्छी तरह मिलाएँ",
                "मिश्रण को सामान्य रूप से आटे का आकार दें। यदि आपको लगता है कि चावल के दाने बहुत लंबे हैं, तो आप उन्हें बाकी सामग्री के साथ मिलाने से पहले थोड़ा सा मैश भी कर सकते हैं। लेकिन हमारा सुझाव है कि आप उन्हें वैसे ही उपयोग करें जैसे वे हैं एक कुरकुरा स्वाद",
                "अब, आटे का एक छोटा सा हिस्सा लें और उसे बेलन की मदद से एक जैसा बेल लें", "धीमी-मध्यम आंच पर एक तवा गर्म करें। उस पर थोड़ा सा तेल लगाएं और तैयार रोटला को उस पर रखें",
                "सुनहरा भूरा और कुरकुरा होने तक पकाएं। पलटें और दूसरी तरफ पकाएं, और आपका चावल का रोटला स्वाद के लिए तैयार है"};

        String vegrotihm[]={"Take the boiled mixed vegetables in a bowl","Add all the ingredients (except atta and oil) and mash well",
        "Add atta to it and knead with luke warm water","Cut small roundels and hand-press into rotis","Brush some oil and toast well on medium to low flame",
        "Enjoy hot with dahi"};

        String hindivegrotihm[]={"उबली हुई मिश्रित सब्जियों को एक कटोरे में लें", "सभी सामग्री (आटा और तेल को छोड़कर) डालें और अच्छी तरह से मैश करें",
                "इसमें आटा मिलाएं और गुनगुने पानी से गूंथ लें", "छोटे-छोटे गोल टुकड़े काट लें और हाथ से दबाकर रोटियां बना लें", "थोड़ा सा तेल लगाकर मध्यम से धीमी आंच पर अच्छे से टोस्ट कर लें",
                "दही के साथ गर्मागर्म आनंद लें"};


        String moonghm[]={"Wash and soak the rice for half an hour","In a heavy-bottomed saucepan or kadhai, heat oil and add cumin seeds followed by the whole spices listed above (cinnamon, cloves, etc.)",
        "Add the ginger garlic paste and saute for a minute or so until the rawness goes away","Add the sliced onion. Once it turns translucent, add the chopped tomato and green chillies",
        "Add haldi, chilli powder, garam masala and 2 tsp salt. Add the mint and coriander leaves","Let it simmer on low flame for around 5 minutes, till the mixture leaves the oil","Add the moong sprouts and the rice (after draining) to the vessel",
        "Pour in 3 cups of hot water. Stir and cover the vessel. Allow the dish to cook on low flame for 15-20 minutes",
        "Later, squeeze lemon juice on top, garnish with chopped coriander leaves and serve hot"};

        String hindimoonghm[]={"चावल को धोकर आधे घंटे के लिए भिगो दें", "एक भारी तले वाले सॉस पैन या कढ़ाई में तेल गर्म करें और जीरा डालें और ऊपर सूचीबद्ध सभी मसाले (दालचीनी, लौंग, आदि) डालें",
                "अदरक लहसुन का पेस्ट डालें और एक मिनट तक भूनें जब तक कि कच्चापन दूर न हो जाए", "कटा हुआ प्याज डालें। एक बार जब यह पारदर्शी हो जाए, तो कटा हुआ टमाटर और हरी मिर्च डालें",
                "हल्दी, मिर्च पाउडर, गरम मसाला और 2 चम्मच नमक डालें। पुदीना और धनिया पत्ती डालें", "इसे धीमी आंच पर लगभग 5 मिनट तक पकने दें, जब तक कि मिश्रण तेल न छोड़ दे", "मूंग के दाने और चावल डालें (पानी निकालने के बाद) बर्तन में",
        "3 कप गर्म पानी डालें। हिलाएँ और बर्तन को ढक दें। डिश को धीमी आंच पर 15-20 मिनट तक पकने दें",
                "बाद में ऊपर से नींबू का रस निचोड़ें, कटी हरी धनिया से सजाएं और गरमागरम परोसें"};


        String srihm[]={"To make this roti, add grated coconut, green chillies, onion, curry leaves, and salt to a bowl. Mix well and squeeze out the excess water",
        "Now, add maida along with some water and knead to form a smooth dough. Keep it aside for 5-10 minutes","Grease your hands with oil and divide the dough into equal portions. Take one of the dough balls and flatten it gently using your fingers",
        "Heat a tawa set on a low-medium flame and place the flattened dough on it. Cook on each side until it becomes golden brown and crispy. You can even drizzle some ghee over it",
        "Repeat the process with the remaining dough. Sri Lankan pol roti is ready! Serve hot and enjoy"};

        String hindisrihm[]={"इस रोटी को बनाने के लिए एक कटोरे में कसा हुआ नारियल, हरी मिर्च, प्याज, करी पत्ता और नमक डालें। अच्छी तरह मिलाएँ और अतिरिक्त पानी निचोड़ लें",
                "अब, मैदा में थोड़ा पानी मिलाएं और चिकना आटा गूंथ लें। इसे 5-10 मिनट के लिए अलग रख दें", "अपने हाथों को तेल से चिकना कर लें और आटे को बराबर भागों में बांट लें। आटे की एक लोई लें और उसे चपटा कर लें। अपनी उंगलियों का धीरे से उपयोग करते हुए",
                "धीमी-मध्यम आंच पर एक तवा गर्म करें और उस पर चपटा आटा रखें। दोनों तरफ से सुनहरा भूरा और कुरकुरा होने तक पकाएं। आप इसके ऊपर थोड़ा घी भी छिड़क सकते हैं",
                "बचे हुए आटे के साथ प्रक्रिया को दोहराएं। श्रीलंकाई पोल रोटी तैयार है! गरमागरम परोसें और आनंद लें"};




















        String arrhind[]={"पकौड़े के लिए:", "2 बड़े चम्मच बेसन", "1/2 बड़ा चम्मच मिर्च पाउडर", "1/4 हल्दी", "1/4 अजवाइन",
                "1/4 जीरा", "1 चम्मच घी", "नमक स्वादानुसार", "तेल तलने के लिए", "कढ़ी के लिए", "1 कप बेसन",
                "1 कप खट्टा दही", "1/2 चम्मच हल्दी", "1/2 मिर्च पाउडर", "1 चम्मच धनिया पाउडर", "1/2 चम्मच हींग", "1 चम्मच नमक", "2 चम्मच घी", "1/2 चम्मच सरसों के बीज", "1/2 चम्मच जीरा",
                "2 तेज पत्ते", "4 लौंग", "2 हरी इलायची", "1 इंच दालचीनी की छड़ी", "4-6 काली मिर्च", "1 इंच अदरक, पतली कटी हुई", "2 हरी मिर्च, मोटे तौर पर कटी हुई" ,
                "तड़का लगाने के लिए:", "1 बड़ा चम्मच घी", "5-6 लहसुन की कलियाँ, कुटी हुई", "1/2 छोटा चम्मच मिर्च पाउडर", "2-3 साबुत सूखी लाल मिर्च"};
        String achaarihind[]={"300 ग्राम पनीर, टुकड़ों में", "2 कप चावल", "1 बड़ा चम्मच तेल", "1-2 बड़े चम्मच नींबू या हरी मिर्च का अचार", "4-5 काली मिर्च", "1 छोटा चम्मच जीरा",
                "1 चम्मच सौंफ", "1 चम्मच कलौंजी के बीज", "1 हरी शिमला मिर्च, कटी हुई", "1 पीली शिमला मिर्च, कटी हुई", "1 लाल शिमला मिर्च, कटी हुई", "1/2 कप दही ",
                "1 चम्मच लाल मिर्च पाउडर", "1/2 चम्मच हल्दी", "1-2 तेज पत्ता", "3-4 कप पानी", "नमक, स्वादानुसार", "धनिया पत्ती, गार्निश के लिए"};
        String chanaDalhind[]={"1/2 कप चना दाल", "1 कप मैदा", "1 बड़ा चम्मच घी", "1 छोटा चम्मच लाल मिर्च पाउडर", "1 छोटा चम्मच धनिया पाउडर", "1 छोटा चम्मच गरम मसाला",
                "1 चम्मच चाट मसाला", "1-2 हरी मिर्च, कटी हुई", "1 इंच अदरक, कटी हुई", "1/4 चम्मच बेकिंग सोडा", "2 चम्मच नींबू का रस", "एक चुटकी हिंग"," स्वादानुसार नमक","पानी, आवश्यकतानुसार",
                "तेल, आवश्यकतानुसार", "काजू (वैकल्पिक)"};
        String cholehind[]={"2 कप चना", "2 बड़े चम्मच चना दाल", "2 मध्यम आकार के प्याज, बारीक कटा हुआ", "2 बड़े टमाटर, बारीक कटा हुआ", "2-3 लहसुन की कलियाँ, बारीक कटा हुआ",
                "1 इंच अदरक का टुकड़ा, कसा हुआ", "2-3 हरी मिर्च", "1 चम्मच जीरा", "1 चम्मच हल्दी पाउडर", "1 चम्मच जीरा पाउडर", "1 चम्मच धनिया पाउडर", "1/ 2 चम्मच लाल मिर्च पाउडर (स्वादानुसार समायोजित करें)",
                "1/2 छोटा चम्मच गरम मसाला", "स्वादानुसार नमक", "2 बड़े चम्मच खाना पकाने का तेल", "गार्निश के लिए ताजा धनिया पत्ती", "गार्निश के लिए कटा हुआ प्याज, नींबू के टुकड़े, और ताजा हरा धनिया।"};
        String bangalihind[]={"350 ग्राम चना","3 आलू","2 टमाटर","2-3 सूखी लाल मिर्च","1 चम्मच लाल मिर्च पाउडर","1/2 चम्मच हल्दी","1/2 चम्मच जीरा चूर्ण",
                "1/2 चम्मच गरम मसाला", "1 ½ चम्मच अदरक-लहसुन का पेस्ट", "2 तेजपत्ता", "1 बड़ा चम्मच घी", "3 बड़े चम्मच तेल", "1 चम्मच चीनी", "नमक, स्वादानुसार"};
        String cheesyhind[]={"2 कप आपका पसंदीदा पास्ता", "2 बड़े चम्मच जैतून का तेल", "2 कप सब्जियाँ (ब्रोकोली, मक्का, शिमला मिर्च, मशरूम, आदि)", "2 बड़े चम्मच मक्खन",
                "2 बड़े चम्मच मैदा", "2 कप दूध", "2 कप कसा हुआ पनीर (चेडर, मोज़ेरेला, परमेसन, या एक मिश्रण)", "नमक और काली मिर्च स्वाद के लिए"};
        String moonghind[]={"1 कप चावल", "1 कप अंकुरित हरी मूंग", "1 प्याज, बारीक कटा हुआ", "1 टमाटर, बारीक कटा हुआ", "3-4 हरी मिर्च, बारीक कटी", "1 चम्मच अदरक लहसुन का पेस्ट",
                "1/2 कप धनिया पत्ती","1/2 कप पुदीना पत्ती","1 चम्मच जीरा","1 चम्मच मिर्च पाउडर","1 चम्मच गरम मसाला","1/2 चम्मच हल्दी पाउडर","1 -इंच दालचीनी की छड़ी","4 लौंग",
                "6-8 काली मिर्च", "1 चक्र फूल के बीज", "4 हरी इलायची", "2 तेज पत्ते", "2 बड़े चम्मच तेल", "स्वादानुसार नमक", "3 कप गर्म पानी", "1 चम्मच नींबू का रस ","गार्निश के लिए अतिरिक्त धनिया पत्ती"};
        String ricerotihind[]={"1 कप चावल", "1/2 कप आटा", "1 छोटा प्याज, बारीक कटा हुआ", "1-2 हरी मिर्च, कटी हुई", "1-2 चम्मच दही", "1/4 चम्मच लाल मिर्च पाउडर" ,
                "1/2 चम्मच चाट मसाला", "1/2 चम्मच गरम मसाला", "नमक, स्वादानुसार", "धनिया पत्ती, कटी हुई", "तेल, पकाने के लिए"};
        String vegerotihind[]={"1 कप आटा", "1 कप मिश्रित सब्जियां, उबली हुई", "1 चम्मच भुना जीरा पाउडर", "1.5 चम्मच काली मिर्च पाउडर", "1 चम्मच नींबू का रस", "1 चम्मच प्याज, कटा हुआ",
                "2 हरी मिर्च, बारीक कटी हुई", "1 चम्मच धनिया पत्ती", "काला नमक और नमक, स्वादानुसार", "1/2 चम्मच तेल"};
        String srilankarotihind[]={"2 कप मैदा", "2-3 हरी मिर्च, कटी हुई", "1 कप कसा हुआ नारियल", "1 प्याज, कटा हुआ", "एक मुट्ठी करी पत्ता", "नमक, स्वादानुसार", "पानी, आवश्यकतानुसार ",
                "तेल आवश्यकता अनुसार"};

//for english ingredients

        String arr[]={"For the pakoras:","2 tbsp besan","1/2  tbsp chilli powder","1/4  haldi","1/4  ajwain",
                     "1/4  jeera (cumin seeds)", "1 tsp ghee", "Salt to taste", "Oil for deep-frying", "For the kadhi:", "1 cup besan",
                "1 cup sour curds", "1/2 tsp haldi", "1/2 chilli powder", "1 tsp dhania (coriander) powder", "1/2 tsp hing", "1 tsp salt", "2 tsp ghee", "1/2 tsp mustard seeds", "1/2 tsp jeera (cumin seeds)",
                "2 bay leaves", "4 cloves","2 green cardamoms","1-inch cinnamon stick","4-6 peppercorns","1-inch ginger, thinly sliced","2 green chillies, roughly chopped",
                "For the tadka(tempering):","1 tbsp ghee","5-6 garlic cloves, crushed","1/2 tsp chilli powder","2-3 whole dried red chillies"
                    };
        String [] achaari={"300 gms paneer, cubed","2 cups rice","1 tbsp oil","1-2 tbsp lemon or green chilli pickle","4-5 black peppercorns","1 tsp jeera",
        "1 tsp fennel seeds","1 tsp nigella (kalonji) seeds","1 green bell pepper, chopped","1 yellow bell pepper, chopped","1 red bell pepper, chopped","1/2 cup curd",
        "1 tsp red chilli powder","1/2 tsp haldi","1-2 bay leaf","3-4 cups water","Salt, to taste","Coriander leaves, for garnish"};

        String [] chanaDal={"1/2 Cup chana dal","1 cup maida","1 tbsp ghee","1 tsp red chilli powder","1 tsp dhania powder","1 tsp garam masala",
        "1 tsp chaat masala","1-2 green chillies, chopped","1-inch ginger, chopped","1/4 tsp baking soda","2 tsp lemon juice","A pinch of hing","to taste Salt","Water, as required",
        "Oil, as required","Cashew nuts (optional)"};

        String [] chole={"2 Cups chickpeas","2 tbsp chana dal","2 medium-sized onions, finely chopped","2 large tomatoes, finely chopped","2-3 cloves of garlic, minced",
        "1-inch piece of ginger, grated","2-3 green chilies","1 tsp cumin seeds","1 tsp turmeric powder","1 tsp cumin powder","1 tsp coriander powder","1/2 tsp red chili powder (adjust to taste)",
        "1/2 tsp garam masala","Salt to taste","2 tbsp cooking oil","Fresh coriander leaves for garnish","Sliced onions, lemon wedges, and fresh coriander leaves For the Garnish."};

        String [] bangali={"350 gms chana (cottage cheese)","3 potatoes","2 tomatoes","2-3 dried red chillies","1 tsp red chilli powder","1/2 tsp haldi","1/2 tsp cumin powder",
        "1/2 tsp garam masala","1 ½ tsp ginger-garlic paste","2 bay leaves","1 tbsp ghee","3 tbsp oil","1 tsp sugar","Salt, to taste"};

        String [] cheesy={"2 Cups your favourite pasta","2 tbsp olive oil","2 cups vegetables (broccoli, corn, bell peppers, mushrooms, etc.)","2 tbsp butter",
        "2 tbsp all-purpose flour","2 cup milk","2 cups shredded cheese (cheddar, mozzarella, parmesan, or a mix)","Salt and pepper to taste"};

        String [] moong={"1 Cup rice","1 cup sprouted green moong","1 onion, finely chopped","1 tomato, finely chopped","3-4 green chillies, finely chopped","1 tsp ginger garlic paste",
        "1/2 cup coriander leaves","1/2 cup mint leaves","1 tsp cumin seeds","1 tsp chilli powder","1 tsp garam masala","1/2 tsp haldi powder","1-inch cinnamon stick","4 cloves",
        "6-8 peppercorns","1 star anise seed","4 green cardamoms","2 bay leaves","2 tbsp oil","Salt to taste","3 cups hot water","1 tsp lemon juice","Extra coriander leaves for garnish"};

        String [] riceroti={"1 Cup rice","1/2 cup atta","1 small onion, finely chopped","1-2 green chillies, chopped","1-2 tsp curd","1/4 tsp red chilli powder",
        "1/2 tsp chaat masala","1/2 tsp garam masala","Salt, to taste","Coriander leaves, chopped","Oil, for cooking"};

        String [] vegeroti={"1 Cup atta","1 cup mixed vegetables, boiled","1 tsp roasted jeera powder","1.5 tsp black pepper powder","1 tsp lemon juice","1 tbsp onion, chopped",
        "2 green chillies, finely chopped","1 tsp coriander leaves","Black salt and salt, as per taste","1/2 tsp oil"};

        String [] srilankaroti={"2 Cups maida","2-3 green chillies, chopped","1 cup grated coconut","1 onion, chopped","A handful of curry leaves","Salt, to taste","Water, as required",
        "Oil, as required"};












        arrayList.add(new Mdclass(R.drawable.img,"Zk3pddws0Lg","Rajasthani Kadhi Pakoda Recipe","राजस्थानी कढ़ी पकोड़ा रेसिपी","45 ","Crisp besan pakoras are mixed with an aromatic besan-buttermilk base to make this Rajasthani Kadhi. A regal dish packed with flavours, this kadhi can be an impressive choice for any special lunch or dinner.","इस राजस्थानी कढ़ी को बनाने के लिए कुरकुरे बेसन के पकौड़ों को सुगंधित बेसन-छाछ बेस के साथ मिलाया जाता है। स्वाद से भरपूर एक शाही व्यंजन, यह कढ़ी किसी भी विशेष दोपहर के भोजन या रात के खाने के लिए एक प्रभावशाली विकल्प हो सकती है।",arr,arrhind,arrhm,hindiarrhm));
        arrayList.add(new Mdclass(R.drawable.achaaripaneer_pulao,"Ft1PuQmVKEQ","Achaari Paneer Pulao Recipe","अचारी पनीर पुलाव रेसिपी","30 ",
                "Achaari Paneer Pulao is delicious recipe, this one-pot meal is perfect for those days when you have no time to cook. Pair this amazing pulao with raita or your favorite chutney .","अचारी पनीर पुलाव स्वादिष्ट रेसिपी है, यह वन-पॉट भोजन उन दिनों के लिए बिल्कुल सही है जब आपके पास खाना पकाने का समय नहीं है। इस अद्भुत पुलाव को रायता या अपनी पसंदीदा चटनी के साथ मिलाएं।",achaari,achaarihind,acharihm,hindiacharihm));
        arrayList.add(new Mdclass(R.drawable.chana_dal_kachori,"iWce2vEHZRQ","Chana Dal Kachori Recipe","चना दाल कचौरी रेसिपी","35 ","Kachori is a popular Rajasthani dish and you can find many variations of this delicious snack. Here we bring a yummy recipe of chana dal kachori.","कचौरी एक लोकप्रिय राजस्थानी व्यंजन है और आप इस स्वादिष्ट नाश्ते के कई रूप पा सकते हैं। यहां हम चना दाल कचौरी की एक स्वादिष्ट रेसिपी लेकर आए हैं।",chanaDal,chanaDalhind,chanadalhm,chanaDalhind));
        arrayList.add(new Mdclass(R.drawable.choleee,"hc5VTAp3Ma0","Peshawari Chole Recipe","पेशावरी छोले रेसिपी","40 ","This recipe of Peshawari Chole is very interesting in which you get the authentic flavor of spices. You can make this spicy chickpea curry on special occasions and pair it with naan or roti.","पेशावरी छोले की यह रेसिपी बहुत दिलचस्प है जिसमें आपको मसालों का प्रामाणिक स्वाद मिलता है। आप इस मसालेदार चने की सब्जी को विशेष अवसरों पर बना सकते हैं और इसे नान या रोटी के साथ बना सकते हैं।",chole,cholehind,cholehm,hindicholehm));
        arrayList.add(new Mdclass(R.drawable.bangali_style_chanar_dalna_recipe,"XRby1vp3ZX8","Bengali-Style Chanar Dalna Recipe","बंगाली स्टाइल चनर दालना रेसिपी","20 ","This is a delicious Bengali dish that is made with fresh chana(cottage cheese), tomatoes and spices- You can pair this curry with rice and roti.","यह एक स्वादिष्ट बंगाली व्यंजन है जो ताजा चना (पनीर), टमाटर और मसालों से बनाया जाता है - आप इस करी को चावल और रोटी के साथ जोड़ सकते हैं।",bangali,bangalihind,bangalihm,hindibangalihm));
        arrayList.add(new Mdclass(R.drawable.cheesyes,"rBmSraF9am0","Cheesy Pasta With Vegetables","सब्जियों के साथ पनीर पास्ता","25 ","This is a delicious pasta made with vegetables, cheesy and milk. This Cheesy Pasta can be a comforting meal for those when you don't want to spend so much time in the kitchen.","यह सब्जियों, चीज़ और दूध से बना एक स्वादिष्ट पास्ता है। यह चीज़ी पास्ता उन लोगों के लिए एक आरामदायक भोजन हो सकता है जब आप रसोई में इतना समय नहीं बिताना चाहते हैं।",cheesy,cheesyhind,cheesyhm,hindicheesyhm));
        arrayList.add(new Mdclass(R.drawable.moong_sprouts,"tSCgNafr_p8","Moong Sprouts Rice Recipe","मूंग स्प्राउट्स राइस रेसिपी","35 ",
                "This Maharashtrian-style moong sprouts rice dish is packed with irresistible flavours. It is a delicious and wholesome pulao-like preparation you will love.","यह महाराष्ट्रीयन शैली का मूंग स्प्राउट्स चावल का व्यंजन अनूठे स्वादों से भरपूर है। यह एक स्वादिष्ट और पौष्टिक पुलाव जैसी तैयारी है जो आपको पसंद आएगी।",moong,moonghind,moonghm,hindimoonghm));
        arrayList.add(new Mdclass(R.drawable.rice_rotla,"WeJEFTnmed4","Rice Rotla Reipe","चावल रोटला रेसिपी","20 ","This is a super soft Gujarati dish that can be made with leftover rice, wheat flour, green chilies, chopped onion and some spices.","यह एक बेहद नरम गुजराती व्यंजन है जिसे बचे हुए चावल, गेहूं का आटा, हरी मिर्च, कटा हुआ प्याज और कुछ मसालों के साथ बनाया जा सकता है।",riceroti,ricerotihind,ricerotihm,hindiacharihm));
        arrayList.add(new Mdclass(R.drawable.vegitable_roti,"xAD8y6fGDbg","Vegetable Roti Recipe","सब्जी रोटी रेसिपी","25 ","This is a healthy roti that is perfect for anytime, which is made with whole wheat flour and mix of vegetables. You can pair this delicious roti with plain curd.","यह एक स्वस्थ रोटी है जो किसी भी समय के लिए बिल्कुल उपयुक्त है, जो पूरे गेहूं के आटे और सब्जियों के मिश्रण से बनाई जाती है। आप इस स्वादिष्ट रोटी को सादे दही के साथ मिला सकते हैं।",vegeroti,vegerotihind,vegrotihm,hindivegrotihm));
        arrayList.add(new Mdclass(R.drawable.sri_lankan_pol_roti,"7-lb-zi5B0I","Sri Lankan Pol Roti Recipe","श्रीलंकाई पोल रोटी रेसिपी","25 ","This is a vegetarian dish, which is very easy to make. Sri Lankan Pol Roti is made with coconut] green chilies and with mils spices.","यह एक शाकाहारी व्यंजन है, जिसे बनाना बहुत आसान है। श्रीलंकाई पोल रोटी नारियल] हरी मिर्च और हल्के मसालों के साथ बनाई जाती है।",srilankaroti,srilankarotihind,srihm,hindisrihm));
        recyclerView=findViewById(R.id.recycleOfveg);
        adept=new Adept(this,arrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adept);
        SharedPreferences sharedPreferences=getSharedPreferences("language",MODE_PRIVATE);
        boolean res=sharedPreferences.getBoolean("type",false);
        if(res){
            textView.setText("शाकाहारी भोजन की सूची");
            adept.notifyDataSetChanged();
            toolbar.setTitle("शाकाहारी भोजन");
        }else {
            textView.setText("List of Veg Recipes");
            adept.notifyDataSetChanged();
            toolbar.setTitle("Vegetarian Recipes");
        }

        ImageView gohome=findViewById(R.id.gohomeveg);
        gohome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(VegFood.this, MainActivity.class));
            }
        });






    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.language,menu);
//
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        int id=item.getItemId();
//        SharedPreferences sharedPreferences=getSharedPreferences("language",MODE_PRIVATE);
//        boolean result=sharedPreferences.getBoolean("type",false);
//        if (id==R.id.hindi&&result){
//            textView.setText("शाकाहारी भोजन की सूची");
//            adept.notifyDataSetChanged();
//            SharedPreferences.Editor editor=sharedPreferences.edit();
//            editor.putBoolean("type",true);
//
//        }else {
//            textView.setText("List of Veg Recipes");
//            adept.notifyDataSetChanged();
//            SharedPreferences.Editor editor=sharedPreferences.edit();
//            editor.putBoolean("type",false);
//
//        }
//        return true;
//    }


}