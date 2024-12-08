public enum Internet {
    ZERO(0, "Java Project Assets//Level1-InternetAssets//0.png"),
    ONE(1, "Java Project Assets//Level1-InternetAssets//1.png"),
    TWO(2, "Java Project Assets//Level1-InternetAssets//2.png"),
    THREE(3, "Java Project Assets//Level1-InternetAssets//3.png"),
    FOUR(4, "Java Project Assets//Level1-InternetAssets//4.png"),
    FIVE(5, "Java Project Assets//Level1-InternetAssets//5.png"),
    SIX(6, "Java Project Assets//Level1-InternetAssets//6.png"),
    SEVEN(7, "Java Project Assets//Level1-InternetAssets//7.png"),
    EIGHT(8, "Java Project Assets//Level1-InternetAssets//8.png");

    final int id;
    final String iconfilepath;

    Internet(int id, String iconfilepath) {
        this.id = id;
        this.iconfilepath = iconfilepath;
    }
}
