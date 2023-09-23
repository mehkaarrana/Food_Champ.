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

public class Nonveg extends AppCompatActivity  {
    ArrayList<Mdclass> arrayList;
    Adept adept;
    RecyclerView recyclerView;
    Toolbar toolbar;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nonveg);
        toolbar=findViewById(R.id.toolbarnonveg);
        setSupportActionBar(toolbar);
        textView=findViewById(R.id.listnon);




        String peshawarihm[]={"First, wash the rice nicely and soak it in water for around 20-30 minutes. Drain and keep aside","For the marinade, combine the chicken pieces with dahi, ginger-garlic paste, haldi, biryani masala, garam masala, red chilli powder, and salt in a bowl. Mix well. Keep it in the refrigerator for a while",
        "Boil water in a kadhai and add the soaked rice to it. Add bay leaf, cloves, elaichi, a cinnamon stick, and salt. Cook until the rice is partially done",
        "In a heavy-bottomed pot, add a layer of marinated chicken and top it with the partially cooked rice. Top it with some chopped tomatoes, onions, and coriander leaves. Drizzle oil and repeat the process of layering until it is full to the top. You can even add some saffron strands or kewra water for flavouring",
        "Cover the pot with aluminium foil and cook on a low flame for 40-45 minutes. Serve hot and enjoy!"};

        String hindipeshawarihm[]={"सबसे पहले, चावल को अच्छी तरह से धो लें और इसे लगभग 20-30 मिनट के लिए पानी में भिगो दें। इसे छान लें और एक तरफ रख दें", "मैरिनेड के लिए, चिकन के टुकड़ों को दही, अदरक-लहसुन पेस्ट, हल्दी, बिरयानी मसाला, गरम मसाला के साथ मिलाएं। एक बाउल में लाल मिर्च पाउडर और नमक डालकर अच्छी तरह मिला लें और थोड़ी देर के लिए फ्रिज में रख दें।",
                "एक कढ़ाई में पानी उबालें और उसमें भीगे हुए चावल डालें। तेज पत्ता, लौंग, इलाइची, एक दालचीनी की छड़ी और नमक डालें। चावल के आंशिक रूप से पकने तक पकाएं",
                "एक भारी तले वाले बर्तन में, मैरीनेट किए हुए चिकन की एक परत डालें और इसके ऊपर आंशिक रूप से पके हुए चावल डालें। इसके ऊपर कुछ कटे हुए टमाटर, प्याज और हरा धनिया डालें। तेल छिड़कें और परत भरने की प्रक्रिया को तब तक दोहराएं जब तक कि यह पूरी तरह से भर न जाए। शीर्ष। आप स्वाद के लिए कुछ केसर के धागे या केवड़ा जल भी मिला सकते हैं",
                "बर्तन को एल्युमिनियम फॉयल से ढकें और धीमी आंच पर 40-45 मिनट तक पकाएं। गरमागरम परोसें और आनंद लें!"};

        String chettinadhm[]={"First, wash the rice nicely and soak it in water for around 20-30 minutes. Drain and keep aside","To marinate the chicken, add ginger-garlic paste, yogurt, haldi, red chilli powder, and salt to a bowl. Add the chicken pieces and mix well. Let it set for at least an hour",
        "Now, heat ghee in a heavy-bottomed pan. Add saunf, cloves, a cinnamon stick, and cardamom. Saute well. Add the onions, ginger, and garlic, and saute until the onions become golden brown in colour",
        "To this, add the marinated chicken pieces and cook for a few more minutes. Add chopped tomatoes, green chillies, red chilli powder, and haldi. Mix well",
        "Next, add the yogurt and coriander leaves. Combine everything together and cook for about 4-5 minutes",
        "Now, cover this chicken masala with cooked rice and top it with some fried onions, cashew nuts, and raisins. Cover the lid and allow it to cook for 15-20 minutes. Garnish with fresh coriander leaves, and serve hot!"};


        String hindichettinadhm[]={"सबसे पहले, चावल को अच्छी तरह से धो लें और इसे लगभग 20-30 मिनट के लिए पानी में भिगो दें। इसे छान लें और एक तरफ रख दें", "चिकन को मैरीनेट करने के लिए, एक कटोरे में अदरक-लहसुन का पेस्ट, दही, हल्दी, लाल मिर्च पाउडर और नमक डालें। . चिकन के टुकड़े डालें और अच्छी तरह मिलाएँ। इसे कम से कम एक घंटे के लिए सेट होने दें",
                "अब, एक भारी तले वाले पैन में घी गर्म करें। इसमें सौंफ, लौंग, एक दालचीनी की छड़ी और इलायची डालें। अच्छी तरह से भूनें। प्याज, अदरक और लहसुन डालें और प्याज को सुनहरा भूरा होने तक भूनें",
                "इसमें मैरीनेट किए हुए चिकन के टुकड़े डालें और कुछ मिनट तक पकाएं। कटे हुए टमाटर, हरी मिर्च, लाल मिर्च पाउडर और हल्दी डालें। अच्छी तरह मिलाएँ",
                "इसके बाद, दही और हरा धनिया डालें। सभी चीजों को एक साथ मिलाएं और लगभग 4-5 मिनट तक पकाएं",
                "अब, इस चिकन मसाले को पके हुए चावल से ढक दें और ऊपर से कुछ तले हुए प्याज, काजू और किशमिश डालें। ढक्कन को ढक दें और इसे 15-20 मिनट तक पकने दें। ताजी धनिया पत्ती से सजाएँ और गरमागरम परोसें!"};


        String samosahm[]={"Take refined flour in a vessel and add 2 tbsp ghee, salt as per taste, celery and mix everything well. Now add water little by little and knead the dough",
        "Keep the dough covered with a wet cloth for 20 minutes","Now cut the chicken thighs into small pieces and grind them lightly in a grinder. So that it can become its mince","" +
                "Heat oil in a pan, heat 1 tbsp oil and add cumin, whole coriander and fry for two seconds. Add onion and fry it for a few seconds",
        "Add minced chicken and fry the chicken for a few seconds. Now add salt as per taste","After this, add red chili, coriander powder, cumin powder, mango powder and cook the chicken by mixing it well",
        "Make the flame slow and cover the lid and let it cook for 3 to 4 minutes","After the chicken is cooked, turn off the gas and let the stuffing cool down",
        "Mash the flour once again. Now make a dough out of it and roll it lengthwise and cut it in the middle. Make a cone by applying water around it, fill the chicken stuffing in it and close the lower end. Prepare all the samosas like this",
        "Heat oil in a pan and keep it on low flame. After the oil is hot, add the samosas and fry on low flame till they turn crispy golden brown",
        "Pair samosas with chutney"};

        String hindisamosahm[]={"एक बर्तन में मैदा लें और इसमें 2 बड़े चम्मच घी, स्वादानुसार नमक, अजवाइन डालकर सभी चीजों को अच्छे से मिला लें. अब इसमें थोड़ा-थोड़ा पानी डालते हुए आटा गूंथ लें",
                "आटे को 20 मिनिट के लिए गीले कपड़े से ढककर रख दीजिए", "अब चिकन जांघों को छोटे-छोटे टुकड़ों में काट लीजिए और इन्हें मिक्सी में हल्का पीस लीजिए. ताकि इसका कीमा बन जाए","" +
                "एक पैन में तेल गरम करें, 1 बड़ा चम्मच तेल गरम करें और उसमें जीरा, साबुत धनिया डालकर 2 सेकेंड तक भून लें. प्याज डालकर कुछ सेकेंड तक भून लें",
                "कीमा बनाया हुआ चिकन डालें और चिकन को कुछ सेकंड के लिए भूनें। अब स्वादानुसार नमक डालें", "इसके बाद लाल मिर्च, धनिया पाउडर, जीरा पाउडर, अमचूर पाउडर डालें और चिकन को अच्छे से मिलाकर पकाएं",
                "आंच धीमी कर दें और ढक्कन लगाकर 3 से 4 मिनट तक पकने दें", "चिकन पक जाने के बाद गैस बंद कर दें और स्टफिंग को ठंडा होने दें",
                "आटे को एक बार फिर से मसल लीजिए. अब इसकी लोई बना लीजिए और इसे लंबाई में बेल लीजिए और बीच में से काट लीजिए. इसके चारों ओर पानी लगाकर कोन बना लीजिए, इसमें चिकन की स्टफिंग भर दीजिए और निचले सिरे को बंद कर दीजिए. सारे समोसे तैयार कर लीजिए. इस कदर",
                "एक कड़ाही में तेल गर्म करें और धीमी आंच पर रखें। तेल गर्म होने के बाद इसमें समोसे डालें और धीमी आंच पर कुरकुरे सुनहरे भूरे रंग के होने तक तलें।",
                "समोसे को चटनी के साथ मिलाइये"};

        String punjabihm[]={"First, wash the chicken pieces nicely. In a bowl, add red chilli powder, coriander powder, cumin powder, lemon juice, yogurt, salt, and the chicken pieces. Mix well and keep aside for 30 mins",
        "Now, we need to prepare the masala. For this, add spinach leaves, coriander leaves, mint, green chillies, cashew nuts, ginger, garam masala, haldi and 1 tbsp of water in a blender",
        "Blend everything together to form a smooth paste. (You can add more water if required)","To make the curry, heat ghee in a pan. Add onions and saute until they become golden brown in colour. Now, add the prepared masala and cook for around 2-3mins",
        "Add the marinated chicken pieces and mix well. Cover the pan and allow it to cook for 15-20 mins",
        "Once done, pour in fresh cream and mix everything well. Cook on low flame for another 5 mins. Punjabi-style hariyali chicken is ready!"};

        String hindipunjabihm[]={"सबसे पहले चिकन के टुकड़ों को अच्छे से धो लें। एक बाउल में लाल मिर्च पाउडर, धनिया पाउडर, जीरा पाउडर, नींबू का रस, दही, नमक और चिकन के टुकड़े डालें। अच्छे से मिलाएं और 30 मिनट के लिए अलग रख दें।",
                "अब, हमें मसाला तैयार करने की जरूरत है। इसके लिए, एक ब्लेंडर में पालक के पत्ते, हरा धनिया, पुदीना, हरी मिर्च, काजू, अदरक, गरम मसाला, हल्दी और 1 बड़ा चम्मच पानी डालें।",
                "सभी चीजों को एक साथ मिलाकर एक चिकना पेस्ट बना लें। (यदि आवश्यक हो तो आप अधिक पानी भी मिला सकते हैं)", "करी बनाने के लिए, एक पैन में घी गर्म करें। इसमें प्याज डालें और सुनहरा भूरा होने तक भून लें। अब इसमें तैयार सामग्री डालें। मसाला डालें और लगभग 2-3 मिनट तक पकाएँ",
                "मसालेदार चिकन के टुकड़े डालें और अच्छी तरह मिलाएँ। पैन को ढक दें और इसे 15-20 मिनट तक पकने दें",
                "एक बार हो जाने पर, ताज़ी क्रीम डालें और सब कुछ अच्छी तरह मिलाएँ। धीमी आंच पर और 5 मिनट तक पकाएँ। पंजाबी स्टाइल हरियाली चिकन तैयार है!"};

        String keemahm[]={"First, add the minced mutton to a cooker and add oil, garlic, and haldi. Cook it for 3 to 4 whistles",
        "Once done, transfer to a bowl and add chopped onions, green chillies, and coriander leaves. Mix well",
        "Next, add garam masala, red chilli powder, jeera powder, coriander seed powder, salt, and cornflour. Combine everything together and form a soft dough",
        "Now, make equal-sized tikkis of the mixture and dip them in a bowl of beaten eggs. Coat them with breadcrumbs",
        "Heat a tawa and add some oil to it. Place the prepared tikkis and shallow fry them until they turn golden brown and crispy. Serve hot and enjoy!"};

        String hindikeemahm[]={"सबसे पहले, कुकर में कीमा बनाया हुआ मटन डालें और उसमें तेल, लहसुन और हल्दी डालें। इसे 3 से 4 सीटी आने तक पकाएं",
                "एक बार हो जाने पर, इसे एक कटोरे में निकाल लें और इसमें कटा हुआ प्याज, हरी मिर्च और हरा धनिया डालें। अच्छी तरह मिलाएँ",
                "इसके बाद, गरम मसाला, लाल मिर्च पाउडर, जीरा पाउडर, धनिया बीज पाउडर, नमक और कॉर्नफ्लोर डालें। सभी चीजों को एक साथ मिलाएं और नरम आटा गूंथ लें",
                "अब, मिश्रण की बराबर आकार की टिक्कियां बनाएं और उन्हें फेंटे हुए अंडे के कटोरे में डुबोएं। उन्हें ब्रेडक्रंब के साथ लपेटें",
                "एक तवा गरम करें और उसमें थोड़ा सा तेल डालें। तैयार टिक्की डालें और उन्हें सुनहरा भूरा और कुरकुरा होने तक तलें। गरमागरम परोसें और आनंद लें!"};


        String airfryerhm[]={"Start by dry roasting the chickpea flour on low heat for a few minutes. Allow it to cool down, and then transfer it to a bowl",
        "To this, add yoghurt, ginger-garlic paste, red chilli powder, oil, garam masala, ground coriander, and salt. Mix well",
        "Add the boneless chicken pieces and coat them well with the prepared marinade. Cover the bowl with cling wrap and keep it aside for 20-30 minutes",
        "Once done, add onions and bell peppers to it and mix well. Now, take a skewer and alternatively thread the onion, capsicum, and chicken tikka pieces",
        "Repeat until the entire mixture is finished. Preheat your air fryer to 200 degrees C for 2 minutes. Place the skewers evenly in the air fryer basket and air fry for 10-15 minutes. Serve hot and enjoy!"};


        String hindiairfryerhm[]={"सबसे पहले चने के आटे को धीमी आंच पर कुछ मिनटों के लिए सूखा भून लें। इसे ठंडा होने दें और फिर इसे एक कटोरे में निकाल लें।",
                "इसमें दही, अदरक-लहसुन का पेस्ट, लाल मिर्च पाउडर, तेल, गरम मसाला, पिसा हरा धनिया और नमक डालें। अच्छी तरह मिलाएँ",
                "बोनलेस चिकन के टुकड़े डालें और उन्हें तैयार मैरिनेड से अच्छी तरह कोट करें। कटोरे को क्लिंग रैप से ढकें और 20-30 मिनट के लिए एक तरफ रख दें",
                "एक बार हो जाने के बाद, इसमें प्याज और शिमला मिर्च डालें और अच्छी तरह मिलाएँ। अब, एक सींक लें और वैकल्पिक रूप से इसमें प्याज, शिमला मिर्च और चिकन टिक्का के टुकड़े डालें",
                "पूरा मिश्रण खत्म होने तक दोहराएं। अपने एयर फ्रायर को 2 मिनट के लिए 200 डिग्री सेल्सियस पर पहले से गरम करें। सीखों को एयर फ्रायर बास्केट में समान रूप से रखें और 10-15 मिनट के लिए एयर फ्राई करें। गरमागरम परोसें और आनंद लें!"};

        String lahorihm[]={"Start by heating oil in a kadhai. Add jeera and allow it to splutter. Add chopped onions and saute until they become golden brown in colour",
        "Now, add the ginger-garlic paste, tomatoes, and green chillies. Cook until the tomatoes become soft","Once the oil separates from the tomatoes, add red chilli powder, haldi, salt, and coriander powder. Mix well and cook for a few minutes",
        "Next, add in the chicken pieces and coat them well with the masalas. Cook on high heat until partially cooked. Reduce the heat and add the yoghurt",
        "Give it a nice mix and simmer on low heat until the chicken is fully cooked. Once done, sprinkle kasuri methi and garam masala. Garnish with coriander leaves, and serve hot!"};

        String hindilahorihm[]={"सबसे पहले एक कढ़ाई में तेल गर्म करें। इसमें जीरा डालें और इसे फूटने दें। इसमें कटा हुआ प्याज डालें और इसे सुनहरा भूरा होने तक भून लें।",
                "अब, अदरक-लहसुन का पेस्ट, टमाटर और हरी मिर्च डालें। टमाटर के नरम होने तक पकाएं", "जब टमाटर से तेल अलग हो जाए, तो लाल मिर्च पाउडर, हल्दी, नमक और धनिया पाउडर डालें। अच्छी तरह मिलाएँ और पकाएँ। कुछ मिनट के लिए",
                "इसके बाद, चिकन के टुकड़े डालें और उन्हें मसालों के साथ अच्छी तरह से कोट करें। आंशिक रूप से पकने तक तेज़ आंच पर पकाएं। आंच कम करें और दही डालें",
                "इसे एक अच्छा मिश्रण दें और धीमी आंच पर तब तक पकाएं जब तक कि चिकन पूरी तरह से पक न जाए। एक बार पक जाने पर कसूरी मेथी और गरम मसाला छिड़कें। धनिया पत्ती से सजाएं और गर्मागर्म परोसें!"};


        String momoshm[]={"Combine the all-purpose flour and salt. Gradually add warm water while kneading until a smooth, elastic dough forms. Cover the dough with a damp cloth and let it rest for about 30 minutes",
        "In a separate bowl, mix the minced meat, finely chopped vegetables, minced garlic, grated ginger, soy sauce, sesame oil, salt, and pepper","Divide the dough into small portions. Dust your work surface with flour and roll out each portion into thin circular wrappers, about 3 to 4 inches in diameter. Ensure the edges are slightly thicker than the centre to hold the filling",
        "Take one wrapper and place a spoonful of the filling in the centre. Fold the wrapper in half, creating a half-moon shape, and pinch the edges together to seal",
        "Heat a non-stick pan over medium heat and add enough cooking oil to coat the bottom. Arrange the momos in a single layer, ensuring they don't touch each other. Let them cook undisturbed for a few minutes until the bottoms turn golden and crisp",
        "Flip the momos. Pour a small amount of water into the pan, enough to cover the bottom by about half an inch. Immediately cover the pan with a lid to trap the steam. Allow the momos to steam for about 8 to 10 minutes"};

        String hindimomoshm[]={"मैदा और नमक मिलाएं। चिकना, लोचदार आटा बनने तक गूंधते समय धीरे-धीरे गर्म पानी डालें। आटे को एक नम कपड़े से ढकें और इसे लगभग 30 मिनट तक आराम दें",
                "एक अलग कटोरे में, कीमा बनाया हुआ मांस, बारीक कटी सब्जियां, कीमा बनाया हुआ लहसुन, कसा हुआ अदरक, सोया सॉस, तिल का तेल, नमक और काली मिर्च मिलाएं", "आटे को छोटे भागों में विभाजित करें। अपने काम की सतह पर आटा छिड़कें और बेल लें प्रत्येक भाग को लगभग 3 से 4 इंच व्यास वाले पतले गोलाकार रैपर में रखें। सुनिश्चित करें कि भरावन को पकड़ने के लिए किनारे केंद्र से थोड़े मोटे हों",
        "एक रैपर लें और उसके बीच में एक चम्मच भरावन रखें। आधे चांद का आकार बनाते हुए रैपर को आधा मोड़ें और किनारों को एक साथ चिपकाकर सील कर दें",
                "मध्यम आंच पर एक नॉन-स्टिक पैन गरम करें और तली को कवर करने के लिए पर्याप्त खाना पकाने का तेल डालें। मोमोज को एक परत में व्यवस्थित करें, यह सुनिश्चित करें कि वे एक-दूसरे को न छूएं। उन्हें कुछ मिनट तक बिना किसी रुकावट के पकने दें जब तक कि तली सुनहरी न हो जाए। और कुरकुरा",
                "मोमो को पलटें। पैन में थोड़ा सा पानी डालें, जो तले को लगभग आधा इंच ढकने के लिए पर्याप्त हो। भाप को रोकने के लिए तुरंत पैन को ढक्कन से ढक दें। मोमोज को लगभग 8 से 10 मिनट तक भाप में पकने दें।"};


        String rarahm[]={"To begin making the Himachali Mutton Rara recipe, In a wide pan, dry roast all the garam masala ingredients except the nutmeg and grind them into a powder using a mixer grinder",
        "Mix nutmeg powder in this mixture and keep it aside. Heat mustard oil in a heavy bottomed pan to smoking point and cumin seeds",
        "Add chopped onion, green chillies, garlic and ginger and saute for 10 minutes","Add red chilli powder, turmeric powder and mix it properly. Add tomatoes,salt and sugar",
        "Let it cook for 15 to 20 minutes on medium flame till tomatoes are soft and the oil has risen to the top. Sprinkle little water. Now mix mutton and let it cook for 20 to 25 minutes till it is rich and fully coated with all spices",
        "Add ghee for the flavours. Cover the pan with a lid and let the mutton cook in its own juices for about 30 to 45 minutes","Half way through, sprinkle 1 big tablespoon freshly grounded garam masala. Once the mutton is tender, add some chopped coriander, lime juice and serve hot",
        "Serve Himachali Mutton Rara along with hot steamed"};

        String hindirarahm[]={"हिमाचली मटन रारा रेसिपी बनाना शुरू करने के लिए, एक चौड़े पैन में जायफल को छोड़कर सभी गरम मसाला सामग्री को सूखा भून लें और उन्हें मिक्सर ग्राइंडर का उपयोग करके पाउडर बना लें",
                "इस मिश्रण में जायफल का पाउडर मिलाएं और एक तरफ रख दें। एक भारी तले वाले पैन में सरसों का तेल डालकर धुआं निकलने तक गर्म करें और इसमें जीरा डालें।",
                "कटा हुआ प्याज, हरी मिर्च, लहसुन और अदरक डालें और 10 मिनट तक भूनें", "लाल मिर्च पाउडर, हल्दी पाउडर डालें और अच्छी तरह मिलाएँ। टमाटर, नमक और चीनी डालें",
                "इसे मध्यम आंच पर 15 से 20 मिनट तक पकने दें जब तक कि टमाटर नरम न हो जाएं और तेल ऊपर न आ जाए। थोड़ा पानी छिड़कें। अब मटन मिलाएं और इसे 20 से 25 मिनट तक पकने दें जब तक कि यह अच्छी तरह से पक न जाए और पूरी तरह से इसमें लिपट न जाए। मसाले",
                "स्वाद के लिए घी डालें। पैन को ढक्कन से ढक दें और मटन को अपने रस में लगभग 30 से 45 मिनट तक पकने दें", "आधे रास्ते में, 1 बड़ा चम्मच ताजा पिसा हुआ गरम मसाला छिड़कें। एक बार जब मटन नरम हो जाए, थोड़ा कटा हरा धनिया, नीबू का रस डालें और गरमागरम परोसें",
                "हिमाचलनी मटन रारा को गर्मागर्म स्टीम्ड के साथ परोसें"};

        String crispyhm[]={"Boil the noodles until soft to bite, drain the water and set aside to cool. If you are using samosa patti or spring roll wraps, cut them into long, thin strands like noodles",
                "Clean and cut the chicken into medium-sized strips","Combine all the ingredients of the marinade in a large bowl and then add in the chicken strips. Mix well and let the chicken marinate for around 2 hours",
                "Add 2 tbsp of cornflour to the noodles to ensure they are completely dry. Damp or sticky noodles will lead to problems while frying",
                "Add the remaining corn flour along with the egg to the marinated chicken before frying. Mix all the ingredients well","Coat the chicken strips with the boiled noodles carefully",
                "Heat oil in a kadhai on low flame and deep-fry the strips until golden and crisp",
                "Serve crispy thread chicken hot with sweet and spicy dipping sauces"
        };

        String hindicrispyhm[]={"नूडल्स को नरम होने तक उबालें, पानी निकाल दें और ठंडा होने के लिए अलग रख दें। यदि आप समोसा पट्टी या स्प्रिंग रोल रैप्स का उपयोग कर रहे हैं, तो उन्हें नूडल्स की तरह लंबे, पतले टुकड़ों में काट लें।",
                "चिकन को साफ करें और मध्यम आकार के स्ट्रिप्स में काट लें", "मैरिनेड की सभी सामग्री को एक बड़े कटोरे में मिलाएं और फिर चिकन स्ट्रिप्स डालें। अच्छी तरह मिलाएं और चिकन को लगभग 2 घंटे तक मैरीनेट होने दें",
                "नूडल्स पूरी तरह से सूखे हैं, यह सुनिश्चित करने के लिए उनमें 2 बड़े चम्मच कॉर्नफ्लोर मिलाएं। गीले या चिपचिपे नूडल्स तलते समय समस्या पैदा करेंगे",
                "फ्राई करने से पहले मैरीनेट किए हुए चिकन में अंडे के साथ बचा हुआ मक्के का आटा भी मिला लें. सभी सामग्री को अच्छे से मिला लें", "चिकन स्ट्रिप्स को उबले हुए नूडल्स के साथ सावधानी से कोट करें",
                "धीमी आंच पर एक कढ़ाई में तेल गर्म करें और स्ट्रिप्स को सुनहरा और कुरकुरा होने तक तलें",
                "क्रिस्पी थ्रेड चिकन को मीठी और मसालेदार चटनी के साथ गर्मागर्म परोसें"};




        String peshawarihindi[]={"400 ग्राम चिकन, टुकड़ों में कटा हुआ", "1/2 कप दही", "1 बड़ा चम्मच अदरक-लहसुन का पेस्ट", "1 छोटा चम्मच लाल मिर्च पाउडर", "1/2 छोटा चम्मच हल्दी", "1 छोटा चम्मच गरम मसाला",
                "1 बड़ा चम्मच बिरयानी मसाला", "नमक, स्वादानुसार", "1 ½ कप चावल", "2-3 लौंग", "1 तेज पत्ता", "1 इंच दालचीनी की छड़ी", "2-3 इलाइची"," 1/2 कप कटा हुआ प्याज","1/2 कप टमाटर, कटा हुआ",
                "तेल, आवश्यकतानुसार", "पानी, आवश्यकतानुसार", "केसर, सजावट के लिए", "केवड़ा जल, स्वाद के लिए"};

        String chettinedhindi []={"2 कप चावल", "400 ग्राम चिकन", "2 प्याज, कटे हुए", "2 टमाटर, कटे हुए", "2 हरी मिर्च", "3 लहसुन की कलियाँ, कीमा बनाया हुआ", "1/4 कप दही",
                "2 बड़े चम्मच घी", "1 इंच अदरक का टुकड़ा", "1 छोटा चम्मच हल्दी", "1 छोटा चम्मच लाल मिर्च पाउडर", "1 छोटा चम्मच सौंफ", "3 लौंग", "3 इलायची की फली", "1 छोटा चम्मच धनिया पाउडर",
                "2 बड़े चम्मच तेल", "नमक स्वादानुसार", "एक मुट्ठी धनिया पत्ती", "मैरिनेड के लिए:", "1 चम्मच अदरक-लहसुन का पेस्ट", "1/2 कप दही", "1 चम्मच हल्दी", "1 चम्मच लाल मिर्च पाउडर",
                "  नमक स्वाद अनुसार"};
        String punjabihindi []={"350 ग्राम चिकन", "1 चम्मच धनिया पाउडर", "1 चम्मच लाल मिर्च पाउडर", "1/2 चम्मच जीरा पाउडर", "1/2 कप पालक के पत्ते", "1 कप हरा धनिया",
                "1/2 कप पुदीने की पत्तियां", "4 हरी मिर्च", "1 इंच अदरक, कटी हुई", "1/2 कप काजू", "1/2 चम्मच गरम मसाला", "1/2 कप दही"," 1 बड़ा चम्मच नींबू का रस","5 लहसुन की कलियाँ, कटी हुई",
                "1/2 चम्मच हल्दी", "1 प्याज, कटा हुआ", "1 बड़ा चम्मच घी", "1/4 कप ताजी क्रीम", "स्वादानुसार नमक"};
        String samosahindi []={"आटा बनाने के लिए:"," 2 कप मैदा"," 2 बड़े चम्मच घी"," 1/2 छोटा चम्मच अजवाइन"," स्वादानुसार नमक"," पानी और आवश्यकता","भराई बनाने के लिए:",
                " चिकन थाई(कीमा)"," 1/2 छोटा चम्मच जीरा"," 1/2 छोटा चम्मच साबुत धनिया"," स्वादानुसार नमक"," 1 छोटा चम्मच लाल मिर्च पाउडर"," 1 छोटा चम्मच धनिया पावर"," 1/2 छोटा चम्मच अमचूर पाउडर",
                " 1 चम्मच कसूरी मेथी"," 1 मध्यम प्याज, बारीक कटी"," 1 चम्मच हरी मिर्च, बारीक कटी"," 1 चम्मच अदरक, बारीक कटी"," 1 चम्मच हरा धनिया"," तलने के लिए तेल"};
        String airfryerhindi []={"350 ग्राम बोनलेस चिकन", "1 प्याज, टुकड़ों में", "1 शिमला मिर्च, टुकड़ों में", "1/2 कप दही", "1 बड़ा चम्मच तेल", "1 छोटा चम्मच अदरक-लहसुन का पेस्ट", "1 छोटा चम्मच लाल मिर्च पाउडर",
                "3 चम्मच चने का आटा", "1 चम्मच पिसा हुआ धनिया", "1 चम्मच गरम मसाला", "1 चम्मच कसूरी मेथी", "नमक, स्वादानुसार"};
        String keemahindi []={"300 ग्राम कीमा मटन (पका हुआ)", "1 ½ कप ब्रेडक्रंब", "2 अंडे", "3 छोटे प्याज, कटे हुए", "2 हरी मिर्च, बारीक कटी", "1 बड़ा चम्मच कॉर्नफ्लोर",
                "1 चम्मच लाल मिर्च पाउडर", "1 चम्मच कुचला हुआ लहसुन", "1/2 चम्मच हल्दी", "1 चम्मच गरम मसाला", "1 चम्मच जीरा पाउडर", "2 बड़े चम्मच धनिया पत्ती", "1 चम्मच धनिया बीज पाउडर ",
                "नमक स्वादानुसार", "तेल, तलने के लिए"};
        String lahorihindi []={"500 ग्राम चिकन, टुकड़ों में कटा हुआ", "2 बड़े चम्मच तेल", "1 बड़ा प्याज, कटा हुआ", "2 टमाटर, कटा हुआ", "2 हरी मिर्च, कटा हुआ", "1 चम्मच अदरक-लहसुन का पेस्ट",
                "1 चम्मच लाल मिर्च पाउडर", "1 चम्मच जीरा", "1 चम्मच हल्दी", "1 चम्मच गरम मसाला", "1 चम्मच कसूरी मेथी", "1 चम्मच धनिया पाउडर", "1/4 कप दही"," नमक, स्वादानुसार","धनिया पत्ती, सजावट के लिए"};
        String crispyhindi []={"500 ग्राम बोनलेस चिकन", "4-5 बड़े चम्मच मक्के का आटा", "1 अंडा", "200 ग्राम उबले हुए नूडल्स (या स्प्रिंग रोल रैप्स/समोसा पैटीज़ के 10-12 टुकड़े)", "मैरिनेड के लिए:",
                " 1 बड़ा चम्मच अदरक लहसुन का पेस्ट"," 1 छोटा चम्मच लाल मिर्च पाउडर"," 1/2 छोटा चम्मच काली मिर्च"," 1 छोटा चम्मच सफेद सिरका"," 1/2 छोटा चम्मच सोया सॉस"," 2 बड़े चम्मच मीठी मिर्च/टमाटर चिली सॉस ",
                " 1 चम्मच शेज़वान सॉस/चिली सॉस"," नमक स्वादअनुसार", "तेल तलने के लिए"};
        String momoshindi []={"आटे के लिए:"," 2 कप मैदा"," 1/2 छोटा चम्मच नमक"," गर्म पानी गर्म पानी","भरने के लिए:"," 1 कप कीमा (चिकन या आपकी पसंद)" ,
                " 1 कप सब्जियाँ (गोभी, प्याज, गाजर आदि), बारीक कटी हुई"," 2 कलियाँ लहसुन, बारीक कटी हुई"," 1 चम्मच अदरक, कसा हुआ"," 2 बड़े चम्मच सोया सॉस", "1 बड़ा चम्मच तिल का तेल",
                "नमक और काली मिर्च स्वादानुसार", "पैन-फ्राइंग के लिए:", "खाना पकाने का तेल"};
        String rarahindi []={"1 किलो मटन", "4 बड़े चम्मच सरसों का तेल", "1-1/2 बड़ा चम्मच जीरा", "3 प्याज, कटे हुए", "2 बड़े चम्मच लहसुन (बारीक कटा हुआ)", "2 बड़े चम्मच अदरक (बारीक कटा हुआ) काटा हुआ)",
                "1-1/2 बड़े चम्मच हल्दी पाउडर", "2 बड़े चम्मच लाल मिर्च पाउडर", "2 हरी मिर्च, कटी हुई", "3 टमाटर, बारीक कटे हुए", "2 बड़े चम्मच घी", "1 बड़ा चम्मच नींबू का रस" , "धनिया की पत्तियाँ, कुछ टहनियाँ, बारीक कटी हुई",
                "एक चुटकी चीनी", "स्वादानुसार नमक", "गरम मसाला के लिए", "2 जावित्री", "5 लौंग", "1 इंच दालचीनी की छड़ी (दालचीनी)", "1 तेज पत्ता", "3 इलायची (इलायची) फली/बीज",
                "1 बड़ा चम्मच धनिया के बीज", "1 बड़ा चम्मच जीरा", "1 बड़ा चम्मच जायफल (कद्दूकस किया हुआ)"};





        String peshawari[]={"400 gms chicken, cut into pieces","1/2 cup dahi","1 tbsp ginger-garlic paste","1 tsp red chilli powder","1/2 tsp haldi","1 tsp garam masala",
        "1 tbsp biryani masala","Salt, to taste","1 ½ cup rice","2-3 cloves","1 bay leaf","1-inch cinnamon stick","2-3 elaichis","1/2 cup sliced onions","1/2 cup tomatoes, chopped",
        "Oil, as required","Water, as required","Saffron, for garnishing","Kewra water, for flavour"};

        String chettined[]={"2 Cups rice","400 gram chicken","2 onions, sliced","2 tomatoes, chopped","2 slit green chillies","3 garlic cloves, minced","1/4 cup dahi",
                "2 tbsp ghee","1-inch piece of ginger","1 tsp haldi","1 tsp red chilli powder","1 tsp saunf","3 cloves","3 cardamom pods","1 tsp coriander powder",
        "2 tbsp oil","Salt to taste","A handful of coriander leaves","For the marinade:","  1 tsp ginger-garlic paste","  1/2 Cup yogurt","  1 tsp haldi","  1 tsp red chilli powder",
        "  Salt to taste"};

        String samosa[]={"To make dough:","  2 cups All purpose flour","  2 tbsp Ghee","  1/2 tsp Ajwain","  to taste Salt","  Water ad needed","To Make Stuffing:",
        "  Chicken Thai(mince)","  1/2 tsp Cumin","  1/2 tsp Whole Coriander","  to taste Salt","  1 tsp Red Chili Powder","  1 tsp Coriander Power","  1/2 tsp Amchur Powder",
        "  1 tsp Kasuri Methi","  1 medium Onion, finely chopped","  1 tsp Green Chillies, finely chopped","  1 tsp Ginger, finely chopped","  1 tbsp Coriander leaves","  Oil For Frying"};

        String punjabi[]={"350 gm Chicken","1 tsp Coriander powder","1 tsp Red chilli powder","1/2 tsp Cumin powder","1/2 cup Spinach leaves","1 cup Coriander leaves",
        "1/2 cup Mint leaves","4 Green chillies","1 inch Ginger, chopped","1/2 cup Cashew nuts","1/2 tsp Garam masala","1/2 cup Curd","1 tbsp Lemon juice","5 Garlic cloves, chopped",
        "1/2 tsp Haldi","1 Onion, chopped","1 tbsp Ghee","1/4 cup Fresh cream","to taste Salt"};

        String keema[]={"300 gms minced mutton (cooked)","1 ½ cup breadcrumbs","2 eggs","3 small onions, chopped","2 green chillies, finely chopped","1 tbsp cornflour",
        "1 tsp red chilli powder","1 tsp crushed garlic","1/2 tsp haldi","1 tsp garam masala","1 tsp jeera powder","2 tbsp coriander leaves","1 tsp coriander seed powder",
                "Salt to taste","Oil, for frying"};

        String airfryer[]={"350 gms boneless chicken","1 onion, diced","1 bell pepper, diced","1/2 cup yoghurt","1 tbsp oil","1 tsp ginger-garlic paste","1 tsp red chilli powder",
        "3 tsp chickpea flour","1 tsp ground coriander","1 tsp garam masala","1 tsp kasuri methi","Salt, to taste"};

        String lahori[]={"500 gms chicken, cut into pieces","2 tbsp oil","1 large onion, chopped","2 tomatoes, chopped","2 green chillies, sliced","1 tsp ginger-garlic paste",
        "1 tsp red chilli powder","1 tsp jeera","1 tsp haldi","1 tsp garam masala","1 tsp kasuri methi","1 tsp coriander powder","1/4 cup yoghurt","Salt, to taste","Coriander leaves, for garnish"};

        String momos[]={"For the dough:","  2 cups all-purpose flour","  1/2 tsp salt","  warm water warm water","For the filling:","  1 cup minced meat (chicken or your choice)",
        "  1 cup vegetables (cabbage, onions, carrots, etc.), finely chopped","  2 cloves garlic, minced","  1 tsp ginger, grated","  2 tbsp soy sauce","  1 tbsp sesame oil",
                "  Salt and pepper to taste","For pan-frying:","  Cooking oil"};

        String rara[]={"1 Kg Mutton","4 tbsp Mustard Oil","1-1/2 tbsp Cumin seeds (Jeera)","3 Onions, sliced","2 tbsp Garlic (finely chopped)","2 tbsp Ginger (finely chopped)",
        "1-1/2 tbsp Turmeric powder (Haldi)","2 tbsp Red Chilli powder","2 Green Chillies , chopped","3 Tomatoes , finely chopped","2 tbsp Ghee","1 tbsp Lemon juice","Coriander (Dhania) Leaves , Few sprigs, finely chopped",
        "A pinch of Sugar","to taste Salt","For Garam masala","2 Mace (Javitri)","5 Cloves","1 Inch Cinnamon Stick (Dalchini)","1 Bay Leaf","3 Cardamom (Elaichi) Pods/Seeds",
                "1 tbsp Coriander (Dhania) Seeds","1 tbsp Cumin seeds (Jeera)","1 tbsp Nutmeg (grated)"};

        String crispy[]={"500 gms boneless chicken","4-5 tbsp corn flour","1 egg","200 gram boiled noodles (or 10-12 pieces of spring roll wraps/ samosa pattis)","For the marinade:",
        "  1 tbsp ginger garlic paste","  1 tsp red chilli powder","  1/2 tsp black pepper","  1 tsp white vinegar","  1/2 tsp soy sauce","  2 tbsp sweet chilli/ tomato chilli sauce",
        "  1 tsp schezwan sauce/ chilli sauce","  Salt to taste","  Oil for deep frying"};

        String badamgost[]={"1/2 Kg mutton","1 cups almonds","2 large onions chopped and fried crisp","4 tbsp curd","4 tbsp ghee","1 tbsp ginger-garlic paste",
        "1 tbsp coriander powder","1 tbsp red chili powder","1/2 tsp turmeric powder","Salt as required","1 cinnamon stick","2 bay leaves","4-5 green cardamom",
        "1 black cardamom","3-4 drops kewra/rose water"};

        String badamgosthindi[]={"1/2 किलो मटन", "1 कप बादाम", "2 बड़े प्याज कटे और कुरकुरे तले हुए", "4 बड़े चम्मच दही", "4 बड़े चम्मच घी", "1 बड़ा चम्मच अदरक-लहसुन का पेस्ट",
                "1 बड़ा चम्मच धनिया पाउडर", "1 बड़ा चम्मच लाल मिर्च पाउडर", "1/2 छोटा चम्मच हल्दी पाउडर", "नमक आवश्यकतानुसार", "1 दालचीनी की छड़ी", "2 तेज पत्ते", "4-5 हरी इलायची",
                "1 काली इलायची", "3-4 बूंद केवड़ा/गुलाब जल"};
        String badamgosthm[]={"Wash and soak almonds in hot water for 10 minutes. Peel off the skin and take half the almonds and curd and make a fine paste. Keep it aside",
        "In a pan add ghee and whole spices, once they start to splutter, add mutton and fry until the mutton has changed color","Now add ginger garlic paste and cook until the raw smell is gone",
        "Once the ginger-garlic paste and mutton has mixed well, add coriander, cumin, red chili and turmeric powder, salt and mix well",
        "After around 2 mins add the curd and almonds paste and cook until the masala starts leaving oil",
        "Next add the crushed fried onions and mix well for some time. Once the masala looks cooked, add around 2cups water and leave it to simmer for almost 30 minutes in medium fame with the lid on",
        "Check once if the mutton pieces are soft. Now add the remaining almonds and cook for 2 more minutes. End with adding either kewra or rose water and let it sit with the lid on for 2 minutes",
        "Garnish with coriander leaves and serve hot"};

        String [] hindibadamgosthm={"बादाम को धोकर गर्म पानी में 10 मिनट के लिए भिगो दें। छिलका उतार लें और आधे बादाम और दही लेकर बारीक पेस्ट बना लें। इसे अलग रख दें।",
                "एक पैन में घी और साबुत मसाले डालें, जब वे चटकने लगें, तो मटन डालें और तब तक भूनें जब तक कि मटन का रंग न बदल जाए", "अब अदरक लहसुन का पेस्ट डालें और कच्ची महक खत्म होने तक पकाएं",
                "जब अदरक-लहसुन का पेस्ट और मटन अच्छी तरह मिल जाए तो इसमें धनिया, जीरा, लाल मिर्च और हल्दी पाउडर, नमक डालें और अच्छी तरह मिलाएँ",
                "लगभग 2 मिनट बाद दही और बादाम का पेस्ट डालें और तब तक पकाएं जब तक कि मसाला तेल न छोड़ने लगे",
                "इसके बाद कुचले हुए तले हुए प्याज डालें और कुछ देर तक अच्छी तरह मिलाएँ। जब मसाला पक जाए, तो लगभग 2 कप पानी डालें और ढक्कन लगाकर मध्यम आंच पर लगभग 30 मिनट तक उबलने दें",
                "एक बार जांच लें कि मटन के टुकड़े नरम हैं या नहीं। अब बचे हुए बादाम डालें और 2 मिनट तक पकाएं। अंत में केवड़ा या गुलाब जल डालें और इसे ढक्कन के साथ 2 मिनट तक रहने दें",
                "धनिया पत्ती से सजाकर गरमागरम परोसें"};


        recyclerView=findViewById(R.id.recycleOfnonveg);
        arrayList=new ArrayList<>();
        arrayList.add(new Mdclass(R.drawable.chicken_biryani,"Y8qUA3EqGgs","Peshawari Chicken Biryani Recipe","पेशावरी चिकन बिरयानी रेसिपी","45 ",
                "For those who are biryani lover they will definitely like this peshawari chicken biryani. You can make this delicious biryani on special occasions.","जो लोग बिरयानी के शौकीन हैं उन्हें यह पेशावरी चिकन बिरयानी जरूर पसंद आएगी। आप इस स्वादिष्ट बिरयानी को खास मौकों पर बना सकते हैं।",peshawari,peshawarihindi,peshawarihm,hindipeshawarihm));
        arrayList.add(new Mdclass(R.drawable.chettinad_chicken,"7PHMJG8DjcQ","Chettinad Chicken Biryani Recipe","चेट्टीनाड चिकन बिरयानी रेसिपी","30 ",
                "We all are big fan of biryani. Biryani is a popular one-pot meal recipe- Here we bring a delicious chicken recipe of Chettinad Chicken Biryani which is perfect for every occasion.","हम सभी बिरयानी के बहुत बड़े प्रशंसक हैं। बिरयानी एक लोकप्रिय वन-पॉट मील रेसिपी है - यहां हम चेट्टीनाड चिकन बिरयानी की एक स्वादिष्ट चिकन रेसिपी लेकर आए हैं जो हर अवसर के लिए एकदम सही है।",chettined,chettinedhindi,chettinadhm,hindichettinadhm));
        arrayList.add(new Mdclass(R.drawable.chicken_samosa,"Xz-bUxqh3pI","Chicken Samosa Recipe","चिकन समोसा रेसिपी","40 ",
                "Samosa is a wonderful snack, be it a party or tea time samosa can be a good option to serve. Today we are going to share with you a delicious recipe of Chicken Samosa, in which you will enjoy a lot of spices with chicken.","समोसा एक लाजवाब स्नैक है, पार्टी हो या चाय का समय, समोसा परोसने का एक अच्छा विकल्प हो सकता है. आज हम आपके साथ चिकन समोसा की एक स्वादिष्ट रेसिपी शेयर करने जा रहे हैं, जिसमें चिकन के साथ मसालों का भरपूर आनंद लेंगे. ",samosa,samosahindi,samosahm,hindisamosahm));
        arrayList.add(new Mdclass(R.drawable.hariyali_chicken,"g3QJQQSoQSc","Punjabi-Style Hariyali Chicken Recipe","पंजाबी स्टाइल हरियाली चिकन रेसिपी","40 ",
                "Hariyali chicken tastes quite similar to hariyali chicken tikka, but what sets it apart is that this dish is curry-based. It makes for a wholesome dinner meal when paired with roti or paratha.","हरियाली चिकन का स्वाद काफी हद तक हरियाली चिकन टिक्का जैसा ही होता है, लेकिन जो बात इसे अलग करती है वह यह है कि यह व्यंजन करी पर आधारित है। रोटी या पराठे के साथ खाने पर यह रात के खाने में एक पौष्टिक भोजन बन जाता है।",punjabi,punjabihindi,punjabihm,hindipunjabihm));
        arrayList.add(new Mdclass(R.drawable.kemma_pattice,"X6PO6vOEIgk","Keema Pattice Recipe","कीमा पैटिस रेसिपी","30 ",
                "Keema Pattice is a delicious snack that is perfect for weekend indulgence. You can also serve this keema pattice to your guests.","कीमा पैटिस एक स्वादिष्ट स्नैक है जो सप्ताहांत के आनंद के लिए बिल्कुल उपयुक्त है। आप इस कीमा पैटिस को अपने मेहमानों को भी परोस सकते हैं।",keema,keemahindi,keemahm,hindikeemahm));
        arrayList.add(new Mdclass(R.drawable.air_fryer_chicken_tikka,"MkEEC4Vp-kI","Air Fryer Chicken Tikka Recipe","एयर फ्रायर चिकन टिक्का रेसिपी","25 ",
                "Chicken Tikka is a popular and a delicious snack which traditionally cook in tandoor but here we bring a quick and easy recipe of this. You can make it in a air fryer.","चिकन टिक्का एक लोकप्रिय और स्वादिष्ट स्नैक है जो पारंपरिक रूप से तंदूर में पकाया जाता है लेकिन यहां हम इसकी एक त्वरित और आसान रेसिपी लेकर आए हैं। आप इसे एयर फ्रायर में बना सकते हैं।",airfryer,airfryerhindi,airfryerhm,hindiairfryerhm));
        arrayList.add(new Mdclass(R.drawable.lahori_chicken,"R9rPRA8nZRA","Lahori Kadhai Chicken Recipe","लाहोरी कढ़ाई चिकन रेसिपी","35 ",
                "This is a delicious recipe and perfect for any occasion you can serve this chicken recipe to your guests.","This is a delicious recipe and perfect for any occasion you can serve this chicken recipe to your guests.",lahori,lahorihindi,lahorihm,hindilahorihm));
        arrayList.add(new Mdclass(R.drawable.pan_fried_momos,"DaHO4MBkWKY","Chicken Pan-Fried Momos Recipe","चिकन पैन-फ्राइड मोमोज़ रेसिपी","25 ",
                "We all are big fan of momos and we can find many amazing version of it, here we bring a delicious recipe of Chicken Pan-Fried Momos that is made with a spicy sauce, which make it this snack flavourful.","हम सभी मोमोज के बहुत बड़े प्रशंसक हैं और हमें इसके कई अद्भुत संस्करण मिल सकते हैं, यहां हम चिकन पैन-फ्राइड मोमोज की एक स्वादिष्ट रेसिपी लेकर आए हैं जो मसालेदार सॉस के साथ बनाई गई है, जो इस स्नैक को स्वादिष्ट बनाती है।",momos,momoshindi,momoshm,hindimomoshm));
        arrayList.add(new Mdclass(R.drawable.rara_mutton,"MmI8tSaAXgQ","Rara Mutton Recipe","रारा मटन रेसिपी","35 ",
                "This Himachali dish is popularly enjoyed during special events and festive occasions. Prepared with a mélange of classic Indian spices, this soulful red mutton curry shall make your mouth water.","यह हिमाचली व्यंजन विशेष आयोजनों और उत्सव के अवसरों के दौरान लोकप्रिय रूप से आनंद लिया जाता है। क्लासिक भारतीय मसालों के मिश्रण से तैयार, यह भावपूर्ण लाल मटन करी आपके मुंह में पानी ला देगी।",rara,rarahindi,rarahm,hindirarahm));
        arrayList.add(new Mdclass(R.drawable.thread_chicken,"_T8yeg8SxLc","Crispy Thread Chicken Recipe","क्रिस्पी थ्रेड चिकन रेसिपी","35 ",
                "This chicken appetiser is a spicy treat you’ll find hard to resist. Chicken strips marinated in a flavourful mixture are coated with boiled noodles and then deep-fried to golden.","यह चिकन ऐपेटाइज़र एक मसालेदार व्यंजन है जिसका विरोध करना आपके लिए मुश्किल होगा। स्वादिष्ट मिश्रण में मैरीनेट किए गए चिकन स्ट्रिप्स को उबले हुए नूडल्स के साथ लेपित किया जाता है और फिर सुनहरा होने तक डीप फ्राई किया जाता है।",crispy,crispyhindi,crispyhm,hindicrispyhm));
        arrayList.add(new Mdclass(R.drawable.badamgostkorma,"L4t-3XYqp_E","Badam Gosht Korma Recipe","बादाम गोश्त कोरमा रेसिपी","60 ",
                "This is a delicious curry which is made by almond, curd and whole spices. This curry is perfect for your next dinner party.","यह एक स्वादिष्ट करी है जो बादाम, दही और साबुत मसालों से बनाई जाती है. यह करी आपकी अगली डिनर पार्टी के लिए बिल्कुल उपयुक्त है।",
                badamgost,badamgosthindi,badamgosthm,hindibadamgosthm));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adept=new Adept(this,arrayList);
        adept.notifyDataSetChanged();
        recyclerView.setAdapter(adept);



        SharedPreferences sharedPreferences=getSharedPreferences("language",MODE_PRIVATE);
        boolean res=sharedPreferences.getBoolean("type",false);
        if(res){
            textView.setText("मांसाहारी भोजन की सूची");
            adept.notifyDataSetChanged();
            toolbar.setTitle("मांसाहारी भोजन");
        }else {
            textView.setText("List of Non-Veg Recipes");
            adept.notifyDataSetChanged();
            toolbar.setTitle("Non-Vegetarian Recipes");

        }

        ImageView gohome=findViewById(R.id.gohomenon);
        gohome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Nonveg.this, MainActivity.class));
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
//            textView.setText("मांसाहारी भोजन की सूची");
//            adept.notifyDataSetChanged();
//            SharedPreferences.Editor editor=sharedPreferences.edit();
//            editor.putBoolean("type",true);
//        }else {
//            textView.setText("List of Non-Veg Recipes");
//            adept.notifyDataSetChanged();
//            SharedPreferences.Editor editor=sharedPreferences.edit();
//            editor.putBoolean("type",false);
//        }
//        return true;
//    }



}