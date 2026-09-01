void main() {
    var a1 = new Person("a", 1);
    var a2 = new Person("a", 2);
    var b10 = new Person("b", 10);
    var b20 = new Person("b", 20);

    assert sortByAgeAsc(a2, a1, b20, b10).equals(List.of(a1, a2, b10, b20));
    assert sortByAgeDesc(a2, a1, b20, b10).equals(List.of(b20, b10, a2, a1));
    assert sortByAgeAndNameAsc(a2, b20, a1, b10).equals(List.of(a1, a2, b10, b20));
}

record Person(String name, int age) {}

List<Person> sortByAgeAsc(Person... people) {
    return Arrays.stream(people)
        .sorted(Comparator.comparing(Person::age))
        .toList();
}

List<Person> sortByAgeDesc(Person... people) {
    return Arrays.stream(people)
        .sorted(Comparator.comparing(Person::age).reversed())
        .toList();
}

List<Person> sortByAgeAndNameAsc(Person... people) {
    return Arrays.stream(people)
        .sorted(Comparator.comparing(Person::age).thenComparing(Person::name))
        .toList();
}