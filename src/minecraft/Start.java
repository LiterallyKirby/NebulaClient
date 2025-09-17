public static void main(String[] args) {
    // Point java.library.path to ./natives
    System.setProperty("java.library.path", new File("natives").getAbsolutePath());

    // This is needed because java.library.path is cached internally
    try {
        Field fieldSysPath = ClassLoader.class.getDeclaredField("sys_paths");
        fieldSysPath.setAccessible(true);
        fieldSysPath.set(null, null);
    } catch (Exception e) {
        e.printStackTrace();
    }

    Main.main(concat(new String[] {
        "--version", "mcp",
        "--accessToken", "0",
        "--assetsDir", "assets",
        "--assetIndex", "1.8",
        "--userProperties", "{}"
    }, args));
}
