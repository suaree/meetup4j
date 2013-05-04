package net.suaree.meetup.model;

/**
 * Represents the category values used with the Meetup APIs.
 *
 * @author roger
 */
public enum Category {
    ArtsAndCulture(1),
    CareerAndBusiness(2),
    CarsAndMotorcycles(3),
    CommunityAndEnvironment(4),
    Dancing(5),
    EducationAndLearning(6),
    FashionAndBeauty(8),
    Fitness(9),
    FoodAndDrink(10),
    Games(11),
    MovementsAndPolitics(13),
    HealthAndWellbeing(14),
    HobbiesAndCrafts(15),
    LanguageAndEthnicIdentity(16),
    LGBT(12),
    Lifestyle(17),
    LiteratureAndWriting(18),
    MoviesAndFilm(20),
    Music(21),
    NewAgeAndSpirituality(22),
    OutdoorsAndAdventure(23),
    Paranormal(24),
    ParentsAndFamily(25),
    PetsAndAnimals(26),
    Photography(27),
    ReligionAndBeliefs(28),
    SciFiAndFantasy(29),
    Singles(30),
    Socializing(31),
    SportsAndRecreation(32),
    Support(33),
    Tech(34),
    Women(35);

    private final int id;

    private Category(int id) {
        this.id = id;
    }

    /**
     * Gets the category ID as used in the Meetup APIs.
     *
     * @return A String that represents the category ID for the Meetup APIs.
     */
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return Integer.toString(id);
    }
}
