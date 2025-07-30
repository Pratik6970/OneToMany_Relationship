🔗 One-to-Many Relationship Example Using Hibernate (Java)
This project showcases how to implement a One-to-Many relationship in Java using Hibernate ORM with annotation-based configuration.

🧠 What It Demonstrates:
A Student can have multiple Books, representing a one-to-many association.

This reflects real-world relationships, such as a single user having multiple orders, or a customer owning multiple addresses.

Hibernate manages the relationship between the two entities and handles the persistence logic automatically.

🛠️ Key Highlights:
ORM Framework: Hibernate (with JPA annotations)

Entities Involved:

Student (Parent)

Books (Child)

Annotations Used: @OneToMany, @ManyToOne, @JoinColumn, and cascading types

CascadeType.ALL: Ensures that save/delete operations on the parent are automatically applied to the children

Database Mapping: Tables are generated automatically based on the annotated classes
