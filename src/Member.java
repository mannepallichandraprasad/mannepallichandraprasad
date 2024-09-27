public class Member {
    private String name;
    private String memberId;
    private String email;
    private String phoneNumber;

    // Constructor
    public Member(String name, String memberId, String email, String phoneNumber) {
        this.name = name;
        this.memberId = memberId;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Method to display member info
    public void displayMemberInfo() {
        System.out.println("Member Info:");
        System.out.println("Name: " + name);
        System.out.println("Member ID: " + memberId);
        System.out.println("Email: " + email);
        System.out.println("Phone Number: " + phoneNumber);
    }
}
