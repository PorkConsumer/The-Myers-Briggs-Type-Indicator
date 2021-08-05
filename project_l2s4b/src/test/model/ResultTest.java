package model;

import expection.LabelNotFoundException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ResultTest {
    private Result dummy;

    @BeforeEach
    void runBefore() {
        dummy = new Result("Psychology", "test");
    }

    @Test
    void testGetters() {
        assertEquals("Psychology", dummy.getName());
        assertEquals("test", dummy.getLabel());
    }

    @Test
    void testFindDescriptionNoException() {
        Result ada = new Result("Ada", "estj");
        try {
            ada.findDescription();
        } catch (LabelNotFoundException e) {
            fail("LabelNotFoundException was thrown");
        }
    }

    @Test
    void testFindDescriptionThrowException() {
        try {
            dummy.findDescription();
            fail("LabelNotFoundException should have been thrown");
        } catch (LabelNotFoundException e) {
            // expected
        }
    }

    @Test
    void testEstj() {
        Result ada = new Result("Ada", "estj");
        ada.checkEstj();
        assertEquals(ada.getDescription(), "ESTJ - MANAGER\n"
                + "Practical and consistent, you like to have order everywhere by planning and organizing "
                + "everything.\n" + "But most of all, you like to convince people of your rightness and make them "
                + "think the way you think.\n" + "You look at life soberly and, above all, trust facts.\n" + "\n"
                + "You are open for communication, meeting new people, and spending time at parties.\n"
                + "You never forget to take care of your close ones and can express your love very well.");
        dummy.checkEstj();
        assertNull(dummy.getDescription());
    }

    @Test
    void testEntj() {
        Result ada = new Result("Ada", "entj");
        ada.checkEntj();
        assertEquals(ada.getDescription(), "ENTJ - COMMANDER\n"
                + "Life for you is a struggle and extreme. This is how you know yourself and others.\n"
                + "Being risky and brave, you are easily inspired to start something new.\n"
                + "At the same time, you assess your abilities, both strengths and weaknesses, quite adequately.\n"
                + "\n" + "You feel new tendencies very well and are open to new ideas.\n"
                + "You think positively and adore sport and everything connected to it.");
        dummy.checkEntj();
        assertNull(dummy.getDescription());
    }

    @Test
    void testEsfj() {
        Result ada = new Result("Ada", "esfj");
        ada.checkEsfj();
        assertEquals(ada.getDescription(), "ESFJ - TEACHER\n"
                + "You get along with people very well, and you are the life of any party.\n"
                + "You are attentive, caring, and always ready to help, even if you have to sacrifice your "
                + "personal interests for others.\n" + "\n"
                + "Yet you are very independent in your deals and, as a rule, "
                + "you get everything without any side help.\n"
                + "You only wait for emotional support from your close ones.");
        dummy.checkEsfj();
        assertNull(dummy.getDescription());
    }

    @Test
    void testEstp() {
        Result ada = new Result("Ada", "estp");
        ada.checkEstp();
        assertEquals(ada.getDescription(), "ESTP - MARSHAL\n"
                + "\"Participation is more important than victory.\"\n"
                + "This is not about you.\n"
                + "You strive to reach your goals by any means, even if you have to use physical strength.\n"
                + "You stick to an exact plan, and you can't stand dependence and compromises.\n" + "\n"
                + "You're a born fighter, very active and self-organized.\n"
                + "You can objectively evaluate even the most stressful situation and give a "
                + "quick and exact response.");
        dummy.checkEstp();
        assertNull(dummy.getDescription());
    }

    @Test
    void testEnfj() {
        Result ada = new Result("Ada", "enfj");
        ada.checkEnfj();
        assertEquals(ada.getDescription(), "ENFJ - MENTOR\n"
                + "You are emotional and talkative with rich facial expressions and gesticulations.\n"
                + "You are very empathetic to other people's emotions, and you can spot even the tiniest "
                + "insincerity.\n"
                + "You are very jealous and distrustful in love relationships.\n" + "\n"
                + "Very often, you are ready to face upcoming events because of your ability to feel them "
                + "in advance.");
        dummy.checkEnfj();
        assertNull(dummy.getDescription());
    }

    @Test
    void testEntp() {
        Result ada = new Result("Ada", "entp");
        ada.checkEntp();
        assertEquals(ada.getDescription(), "ENTP - INVENTOR\n"
                + "The generator of ideas, you are always seeking to create something new.\n"
                + "You adapt easily to non familiar environments and master different methods of "
                + "work easily.\n" + "\n"
                + "Due to your dislike of traditions and routine, you very often change your professional "
                + "spheres and hobbies,\n"
                + "becoming an innovator and a pioneer.\n"
                + "What is important about you is that not only can you create new ideas but you are also \n"
                + "able to convey them to others and make them come true.");
        dummy.checkEntp();
        assertNull(dummy.getDescription());
    }

    @Test
    void testEsfp() {
        Result ada = new Result("Ada", "esfp");
        ada.checkEsfp();
        assertEquals(ada.getDescription(), "ESFP - POLITICIAN\n"
                + "You can professionally determine the opportunities of your surroundings, and very often you\n"
                + "use this skill to manipulate people.\n"
                + "In communication with people, you primarily follow your personal interests.\n"
                + "However, you try to impress everybody and create the image of a simple person.\n" + "\n"
                + "You stand firmly in the present moment, and you don't like to waste time.\n"
                + "You want quick results, disliking bureaucracy and red tape.");
        dummy.checkEsfp();
        assertNull(dummy.getDescription());
    }

    @Test
    void testEnfp() {
        Result ada = new Result("Ada", "enfp");
        ada.checkEnfp();
        assertEquals(ada.getDescription(), "ENFP - CHAMPION\n"
                + "You are energetic and inquisitive, with very clear creative skills.\n"
                + "You combine the features of both introverts and extroverts,\n "
                + "which is why not only do you get along with people easily but you also empathize well.\n"
                + "You are very good at advising.\n" + "\n"
                + "You perceive life with all the diversity of its possibilities.\n"
                + "You have a very rich imagination and a very high IQ.\n"
                + "You're a very harmonious person, able to keep the balance even in a very quickly "
                + "changing environment.");
        dummy.checkEnfp();
        assertNull(dummy.getDescription());
    }

    @Test
    void testInfp() {
        Result ada = new Result("Ada", "infp");
        ada.checkInfp();
        assertEquals(ada.getDescription(), "INFP - HEALER\n"
                + "A lyricist and dreamer, your inner harmony and self-agreement are always in first place.\n"
                + "Most of your thinking happens deep inside of you.\n"
                + "Nevertheless, you are able to foresee events and understand people well.\n" + "\n"
                + "You like to dress up and try to look good in all circumstances.\n"
                + "You can't be called thrifty, and you often lose sense of time and reality.");
        dummy.checkInfp();
        assertNull(dummy.getDescription());
    }

    @Test
    void testIsfp() {
        Result ada = new Result("Ada", "isfp");
        ada.checkIsfp();
        assertEquals(ada.getDescription(), "ISFP - COMPOSER\n"
                + "You can find joy in simple things, handling routine and monotony easily.\n"
                + "You like to feel needed, which is why you always help other people but never interfere with"
                + " their comfort zone.\n"
                + "You can't stand conflicts, and you can always entertain people and make them laugh.\n" + "\n"
                + "You're a very down-to-earth, practical, caring, tender, reliable, and faithful partner.\n"
                + "You take this world as it is, never trying to lead and manipulate.");
        dummy.checkIsfp();
        assertNull(dummy.getDescription());
    }

    @Test
    void testIntp() {
        Result ada = new Result("Ada", "intp");
        ada.checkIntp();
        assertEquals(ada.getDescription(), "INTP - ARCHITECT\n"
                + "An egghead and philosopher, you don't like too much expressiveness.\n"
                + "You always seek calm emotions and comfort.\n"
                + "You're very careful when making decisions, preferring to analyze and find connections between"
                + " the past, present, and future.\n" + "\n"
                + "You are very sensitive to changes, and you don't handle them easily.\n"
                + "You always try to collect all of your facts, thoughts, and ideas, and that's why you are "
                + "very often tense.");
        dummy.checkIntp();
        assertNull(dummy.getDescription());
    }

    @Test
    void testInfj() {
        Result ada = new Result("Ada", "infj");
        ada.checkInfj();
        assertEquals(ada.getDescription(), "INFJ - ADVISOR\n"
                + "You are perfect at sensing people and their relationships.\n"
                + "You can easily identify moods and hidden talents, which is why people seek advice from you.\n"
                + "However, you are very vulnerable and can't stand aggression and lack of love.\n" + "\n"
                + "Your driving force is intuition, aimed not outside but inside.\n"
                + "This type of person never stops learning, considering self-development to be a main priority.\n"
                + "By getting to know yourself, you help others.");
        dummy.checkInfj();
        assertNull(dummy.getDescription());
    }

    @Test
    void testIntj() {
        Result ada = new Result("Ada", "intj");
        ada.checkIntj();
        assertEquals(ada.getDescription(), "INTJ - INSPIRER\n"
                + "You have the richest inner world from where you get your incredible ideas.\n"
                + "You strive for excellence and want to improve everything and everybody.\n" + "\n"
                + "However, you have some difficulties in relationships with people,\n"
                + "very often distancing yourself intentionally to demonstrate your independence.\n"
                + "You can set priorities and trust your intuition.");
        dummy.checkIntj();
        assertNull(dummy.getDescription());
    }

    @Test
    void testIsfj() {
        Result ada = new Result("Ada", "isfj");
        ada.checkIsfj();
        assertEquals(ada.getDescription(), "ISFJ - PROTECTOR\n"
                + "You can't stand falseness and insincerity in relationships.\n"
                + "You distinguish \"strangers\" and keep them at a distance right away.\n"
                + "For the people \"inside your circle,\" you do anything and never ask for anything in return.\n"
                + "\n" + "You are observant and very careful with words and deeds.\n"
                + "Kind and caring, you see your main goal as helping people and making them happier.");
        dummy.checkIsfj();
        assertNull(dummy.getDescription());
    }

    @Test
    void testIstp() {
        Result ada = new Result("Ada", "istp");
        ada.checkIstp();
        assertEquals(ada.getDescription(), "ISTP - HANDYMAN\n"
                + "The handyman, as a rule, has a technical mindset and likes to make things by hand.\n"
                + "You don't hurry with taking decisions and think that it is better twice measured than once "
                + "wrong.\n"
                + "However, you always meet deadlines and you are very punctual by nature.\n"
                + "You perceive this world through feelings, and your opinion of things happening around you "
                + "is very objective and specific.\n"
                + "By nature, you are communicative, but you will refuse communication once you feel insincerity.");
        dummy.checkIstp();
        assertNull(dummy.getDescription());
    }

    @Test
    void testIstj() {
        Result ada = new Result("Ada", "istj");
        ada.checkIstj();
        assertEquals(ada.getDescription(), "ISTJ - INSPECTOR\n"
                + "Thoughtful, pensive, responsible.\n"
                + "You are trustworthy, but you never take things as they are, always analyzing the incoming "
                + "information.\n"
                + "You are not interested in long-term communication and prefer official communication only "
                + "during companionship.\n"
                + "You are aimed at the final result.\n" + "\n"
                + "You like strictness and order, and very often you are pedantic.\n"
                + "You don't live in your dreams, only in the \"here and now.\"");
        dummy.checkIstj();
        assertNull(dummy.getDescription());
    }

    @Test
    void testToJson() {
        JSONObject json = dummy.toJson();
        assertEquals("Psychology", json.get("name").toString());
        assertEquals("test", json.get("label").toString());
    }
}
