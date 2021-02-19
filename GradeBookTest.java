@org.junit.Before
    public void setUp() {

        gradeBook.addScore(75);
        gradeBook.addScore(44);
        gradeBook.addScore(55);


        gradeBook2.addScore(5);
        gradeBook2.addScore(3);
        gradeBook2.addScore(235);
        gradeBook2.addScore(33);


    }

    @org.junit.After
    public void tearDown() {
        gradeBook = null;
        gradeBook2 =null;

    }

    @org.junit.Test
    public void addScore() {

        assertTrue(gradeBook.toString().equals("[75.0, 44.0, 55.0, 0.0, 0.0]"));

        assertTrue(gradeBook2.toString().equals("[5.0, 3.0, 235.0, 33.0, 0.0]"));

          assertEquals(gradeBook.getScoresSize(),3);

          assertEquals(gradeBook2.getScoresSize(),4);



    }

    @org.junit.Test
    public void sum() {

        assertEquals(174, gradeBook.sum(), .0001);

        assertEquals(276, gradeBook2.sum(), .0001);
    }


    @org.junit.Test
    public void minimum() {

        assertEquals(44, gradeBook.minimum(), .001);

        assertEquals(3, gradeBook2.minimum(), .001);
    }

    @org.junit.Test
    public void finalScore() {

        assertEquals(130,gradeBook.finalScore(),.001);

        assertEquals(273,gradeBook2.finalScore(),.001);
    }

    @org.junit.Test
    public void getScoresSize() {

    }

    @org.junit.Test
    public void testToString() {

    }
}