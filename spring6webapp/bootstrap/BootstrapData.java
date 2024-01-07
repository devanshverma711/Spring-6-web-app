package guru.springframework.spring6webapp.bootstrap;


import guru.springframework.spring6webapp.domain.Author;
import guru.springframework.spring6webapp.domain.Book;
import guru.springframework.spring6webapp.domain.Publisher;
import guru.springframework.spring6webapp.repositories.AuthorRepo;
import guru.springframework.spring6webapp.repositories.BookRepo;
import guru.springframework.spring6webapp.repositories.PublisherRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {
    private final AuthorRepo authorRepo;
    private final BookRepo bookRepo;
    private final PublisherRepo publisherRepo;

    public BootstrapData(AuthorRepo authorRepo, BookRepo bookRepo, PublisherRepo publisherRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
        this.publisherRepo = publisherRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        Author Devansh = new Author();
        Devansh.setFirstname("Devansh");
        Devansh.setLastName("Verma");

        Book fan = new Book();
        fan.setTitle("Best Book");
        fan.setIsbn("ABC123");

        Author devanshSaved = authorRepo.save(Devansh);
        Book fanSaved = bookRepo.save(fan);

        Author Ram = new Author();
        Ram.setFirstname("Ram");
        Ram.setLastName("Gopal");

        Book fann = new Book();
        fann.setTitle("Good Novel");
        fann.setIsbn("123XYZ");

        Author RamSaved = authorRepo.save(Ram);
        Book fannSaved = bookRepo.save(fann);

        devanshSaved.getBooks().add(fanSaved);
        RamSaved.getBooks().add(fannSaved);
        fanSaved.getAuthors().add(devanshSaved);
        fannSaved.getAuthors().add(RamSaved);

        Publisher publisher = new Publisher();
        publisher.setPublishername("My Publisher");
        publisher.setAddress("123 linkroad");
        publisher.setCity("Bengalure");
        publisher.setState("Arizona");
        Publisher savedPublisher = publisherRepo.save(publisher);

        fanSaved.setPublisher(savedPublisher);
        fannSaved.setPublisher(savedPublisher);

        authorRepo.save(devanshSaved);
        authorRepo.save(RamSaved);
        bookRepo.save(fanSaved);
        bookRepo.save(fannSaved);

        System.out.println("In BootStrap");
        System.out.println("Author Count : "+authorRepo.count());
        System.out.println("Book Count : "+bookRepo.count());
        System.out.println("Publisher Count : "+publisherRepo.count());


    }
}
