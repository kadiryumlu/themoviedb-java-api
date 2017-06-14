package org.themoviedb.api.utils;

public enum Language {
	Abkhazian("ab"),
	Afar("aa"),
	Afrikaans("af"),
	Akan("ak"),
	Albanian("sq"),
	Amharic("am"),
	Arabic("ar"),
	Aragonese("an"),
	Armenian("hy"),
	Assamese("as"),
	Avaric("av"),
	Avestan("ae"),
	Aymara("ay"),
	Azerbaijani("az"),
	Bambara("bm"),
	Bashkir("ba"),
	Basque("eu"),
	Belarusian("be"),
	Bengali("bn"),
	Bangla("bn"),
	Bihari("bh"),
	Bislama("bi"),
	Bosnian("bs"),
	Breton("br"),
	Bulgarian("bg"),
	Burmese("my"),
	Catalan("ca"),
	Chamorro("ch"),
	Chechen("ce"),
	Chichewa("ny"),
	Chewa("ny"),
	Nyanja("ny"),
	Chinese("zh"),
	Chinese_Simplified("zh-Hans"),
	Chinese_Traditional("zh-Hant"),
	Chuvash("cv"),
	Cornish("kw"),
	Corsican("co"),
	Cree("cr"),
	Croatian("hr"),
	Czech("cs"),
	Danish("da"),
	Divehi("dv"),
	Dhivehi("dv"),
	Maldivian("dv"),
	Dutch("nl"),
	Dzongkha("dz"),
	English("en"),
	Esperanto("eo"),
	Estonian("et"),
	Ewe("ee"),
	Faroese("fo"),
	Fijian("fj"),
	Finnish("fi"),
	French("fr"),
	Fula("ff"),
	Fulah("ff"),
	Pulaar("ff"),
	Pular("ff"),
	Galician("gl"),
	Scottish("gd"),
	Gaelic("gv"),
	Manx("gv"),
	Georgian("ka"),
	German("de"),
	Greek("el"),
	Greenlandic("kl"),
	Guarani("gn"),
	Gujarati("gu"),
	Haitian_Creole("ht"),
	Hausa("ha"),
	Hebrew("he"),
	Herero("hz"),
	Hindi("hi"),
	Hiri_Motu("ho"),
	Hungarian("hu"),
	Icelandic("is"),
	Ido("io"),
	Igbo("ig"),
	Indonesian("in"),
	Interlingua("ia"),
	Interlingue("ie"),
	Inuktitut("iu"),
	Inupiak("ik"),
	Irish("ga"),
	Italian("it"),
	Japanese("ja"),
	Javanese("jv"),
	Kalaallisu("kl"),
	Kannada("kn"),
	Kanuri("kr"),
	Kashmiri("ks"),
	Kazakh("kk"),
	Khmer("km"),
	Kikuyu("ki"),
	Kinyarwanda("rw"),
	Rwanda("rw"),
	Kirundi("rn"),
	Kyrgyz("ky"),
	Komi("kv"),
	Kongo("kg"),
	Korean("ko"),
	Kurdish("ku"),
	Kwanyama("kj"),
	Lao("lo"),
	Latin("la"),
	Latvian("lv"),
	Lettish("lv"),
	Limburgish("li"),
	Limburger("li"),
	Lingala("ln"),
	Lithuanian("lt"),
	Luga_Katanga("lu"),
	Luganda("lg"),
	Ganda("lg"),
	Luxembourgish("lb"),
	Macedonian("mk"),
	Malagasy("mg"),
	Malay("ms"),
	Malayalam("ml"),
	Maltese("mt"),
	Maori("mi"),
	Marathi("mr"),
	Marshallese("mh"),
	Moldavian("mo"),
	Mongolian("mn"),
	Nauru("na"),
	Navajo("nv"),
	Ndonga("ng"),
	Northern_Ndebele("nd"),
	Nepali("ne"),
	Norwegian("no"),
	Norwegian_bokmål("nb"),
	Norwegian_nynorsk("nn"),
	Nuosu("ii"),
	Occitan("oc"),
	Ojibwe("oj"),
	Old_Church_Slavonic("cu"),
	Old_Bulgarian("cu"),
	Oriya("or"),
	Oromo("om"),
	Afaan_Oromo("om"),
	Ossetian("os"),
	Pāli("pi"),
	Pashto("ps"),
	Pushto("ps"),
	Persian("fa"),
	Farsi("fa"),
	Polish("pl"),
	Portuguese("pt"),
	Punjabi_Eastern("pa"),
	Quechua("qu"),
	Romansh("rm"),
	Romanian("ro"),
	Russian("ru"),
	Sami("se"),
	Samoan("sm"),
	Sango("sg"),
	Sanskrit("sa"),
	Serbian("sr"),
	Serbo_Croatian("sh"),
	Sesotho("st"),
	Setswana("tn"),
	Shona("sn"),
	Sichuan_Yi("ii"),
	Sindhi("sd"),
	Sinhalese("si"),
	Siswati("ss"),
	Slovak("sk"),
	Slovenian("sl"),
	Somali("so"),
	Southern_Ndebele("nr"),
	Spanish("es"),
	Sundanese("su"),
	Swahili("sw"),
	Kiswahili("sw"),
	Swati("ss"),
	Swedish("sv"),
	Tagalog("tl"),
	Tahitian("ty"),
	Tajik("tg"),
	Tamil("ta"),
	Tatar("tt"),
	Telugu("te"),
	Thai("th"),
	Tibetan("bo"),
	Tigrinya("ti"),
	Tonga("to"),
	Tsonga("ts"),
	Turkish("tr"),
	Turkmen("tk"),
	Twi("tw"),
	Uyghur("ug"),
	Ukrainian("uk"),
	Urdu("ur"),
	Uzbek("uz"),
	Venda("ve"),
	Vietnamese("vi"),
	Volapük("vo"),
	Wallon("wa"),
	Welsh("cy"),
	Wolof("wo"),
	Western_Frisian("fy"),
	Xhosa("xh"),
	Yiddish("yi"),
	Yoruba("yo"),
	Zhuang("za"),
	Chuang("za"),
	Zulu("zu");
	
	private final String text;

    private Language(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}