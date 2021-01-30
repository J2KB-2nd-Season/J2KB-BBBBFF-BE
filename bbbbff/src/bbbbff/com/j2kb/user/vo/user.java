package bbbbff.com.j2kb.user.vo;

public class User {
   private String member_id;
   private String member_pw;
   private String member_name;
   private String member_adrs;
   private String member_email;
   private String member_phone;
   private Grade grade;
   
   public User(String member_id, String member_pw, String member_name, String member_adrs, String member_email,
         String member_phone, Grade grade) {
      super();
      this.member_id = member_id;
      this.member_pw = member_pw;
      this.member_name = member_name;
      this.member_adrs = member_adrs;
      this.member_email = member_email;
      this.member_phone = member_phone;
      this.grade = grade;
   }

   public String getMember_id() {
      return member_id;
   }

   public void setMember_id(String member_id) {
      this.member_id = member_id;
   }

   public String getMember_pw() {
      return member_pw;
   }

   public void setMember_pw(String member_pw) {
      this.member_pw = member_pw;
   }

   public String getMember_name() {
      return member_name;
   }

   public void setMember_name(String member_name) {
      this.member_name = member_name;
   }

   public String getMember_adrs() {
      return member_adrs;
   }

   public void setMember_adrs(String member_adrs) {
      this.member_adrs = member_adrs;
   }

   public String getMember_email() {
      return member_email;
   }

   public void setMember_email(String member_email) {
      this.member_email = member_email;
   }

   public String getMember_phone() {
      return member_phone;
   }

   public void setMember_phone(String member_phone) {
      this.member_phone = member_phone;
   }

   public Grade getGrade() {
      return grade;
   }

   public void setGrade(Grade grade) {
      this.grade = grade;
   }

   @Override
   public String toString() {
      return "user [member_id=" + member_id + ", member_pw=" + member_pw + ", member_name=" + member_name
            + ", member_adrs=" + member_adrs + ", member_email=" + member_email + ", member_phone=" + member_phone
            + ", grade=" + grade + "]";
   }
   
}