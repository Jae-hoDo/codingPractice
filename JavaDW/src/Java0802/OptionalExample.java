package Java0802;

public class OptionalExample {
    public static void main(String[] args) {
        // Optional 사용하지 않은 경우
        String name = getName();
        if (name  != null) {
            System.out.println(name.length());    // NPE 가능성 있음
        }
    }

    // null을 반환할 수 있는 메서드
    public static String getName() {
        // 실제로는 null을 반환할 수 있는 로직
        return null;
    }
}
