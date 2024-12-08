public enum GamingComputer {
    ZERO(0, "Java Project Assets//Level3-GamingComputerAssets//0.png"),
    ONE(1, "Java Project Assets//Level3-GamingComputerAssets//1.png"),
    TWO(2, "Java Project Assets//Level3-GamingComputerAssets//2.png"),
    THREE(3, "Java Project Assets//Level3-GamingComputerAssets//3.png"),
    FOUR(4, "Java Project Assets//Level3-GamingComputerAssets//4.png"),
    FIVE(5, "Java Project Assets//Level3-GamingComputerAssets//5.png"),
    SIX(6, "Java Project Assets//Level3-GamingComputerAssets//6.png"),
    SEVEN(7, "Java Project Assets//Level3-GamingComputerAssets//7.png"),
    EIGHT(8, "Java Project Assets//Level3-GamingComputerAssets//8.png");

    final int id;
    final String iconfilepath;

    GamingComputer(int id, String iconfilepath) {
        this.id = id;
        this.iconfilepath = iconfilepath;
    }
}