public class SingletonPractice {

    public static void main(String[] args) {

        System.out.println("========== 1. Lazy Singleton ==========");
        LazySingleton lazy1 = LazySingleton.getInstance();
        LazySingleton lazy2 = LazySingleton.getInstance();
        System.out.println(lazy1 == lazy2); // true

        System.out.println("\n========== 2. Synchronized Singleton ==========");
        SynchronizedSingleton sync1 = SynchronizedSingleton.getInstance();
        SynchronizedSingleton sync2 = SynchronizedSingleton.getInstance();
        System.out.println(sync1 == sync2); // true

        System.out.println("\n========== 3. Double Checked Locking Singleton ==========");
        DoubleCheckedSingleton dc1 = DoubleCheckedSingleton.getInstance();
        DoubleCheckedSingleton dc2 = DoubleCheckedSingleton.getInstance();
        System.out.println(dc1 == dc2); // true

        System.out.println("\n========== 4. Eager Singleton ==========");
        EagerSingleton eager1 = EagerSingleton.getInstance();
        EagerSingleton eager2 = EagerSingleton.getInstance();
        System.out.println(eager1 == eager2); // true

        System.out.println("\n========== 5. Enum Singleton ==========");
        EnumSingleton enum1 = EnumSingleton.INSTANCE;
        EnumSingleton enum2 = EnumSingleton.INSTANCE;
        System.out.println(enum1 == enum2); // true
    }
}

/* =================================================
   1️⃣ Lazy Initialization Singleton (NOT thread-safe)
   ================================================= */
class LazySingleton {

    private static LazySingleton instance;

    private LazySingleton() {
        System.out.println("LazySingleton created");
    }

    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}

/* =================================================
   2️⃣ Synchronized Singleton (Thread-safe, slow)
   ================================================= */
class SynchronizedSingleton {

    private static SynchronizedSingleton instance;

    private SynchronizedSingleton() {
        System.out.println("SynchronizedSingleton created");
    }

    public static synchronized SynchronizedSingleton getInstance() {
        if (instance == null) {
            instance = new SynchronizedSingleton();
        }
        return instance;
    }
}

/* =================================================
   3️⃣ Double Checked Locking Singleton (BEST)
   ================================================= */
class DoubleCheckedSingleton {

    private static volatile DoubleCheckedSingleton instance;

    private DoubleCheckedSingleton() {
        System.out.println("DoubleCheckedSingleton created");
    }

    public static DoubleCheckedSingleton getInstance() {
        if (instance == null) { // First check
            synchronized (DoubleCheckedSingleton.class) {
                if (instance == null) { // Second check
                    instance = new DoubleCheckedSingleton();
                }
            }
        }
        return instance;
    }
}

/* =================================================
   4️⃣ Eager Initialization Singleton
   ================================================= */
class EagerSingleton {

    private static final EagerSingleton INSTANCE = new EagerSingleton();

    private EagerSingleton() {
        System.out.println("EagerSingleton created");
    }

    public static EagerSingleton getInstance() {
        return INSTANCE;
    }
}

/* =================================================
   5️⃣ Enum Singleton (BEST & SAFEST)
   ================================================= */
enum EnumSingleton {
    INSTANCE;

    EnumSingleton() {
        System.out.println("EnumSingleton created");
    }
}
