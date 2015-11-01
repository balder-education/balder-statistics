package br.com.balder.baldersatistics.model.domain;

/**
 * @author Rogério Fontes
 */
class StundentBuilder {

    private String id;
    private String name;
    private String emal = "NOT_IMPORTANT";

    StundentBuilder() {

    }

    StundentBuilder name(String name) {
        this.name = name;
        return this;
    }

    StundentBuilder id(String id) {
        this.id = id;
        return this;
    }

    StundentBuilder email(String email) {
        this.emal = email;
        return this;
    }

   // Student build() {
       // Student student = Student.getBuilder().nameAndEmail(name, emal).build();

       // ReflectionTestUtils.setField(student, "id", id);

       // return student;
    //}
}
