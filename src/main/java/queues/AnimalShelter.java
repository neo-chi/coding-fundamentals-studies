package queues;
import java.util.LinkedList;
import java.lang.annotation.AnnotationTypeMismatchException;
import java.util.Iterator;


public class AnimalShelter
{
        public LinkedList<Animal> animals = new LinkedList<Animal>();

        public AnimalShelter(Animal[] toShelter)
        {
                for (Animal animal : toShelter) {
                        System.out.println(animal.getClass());
                        animal.sound();
                        animals.add(animal);
                }
        }

        /**
         * Returns the animal that has been at the shelter the longest.
         * @return Animal at end of queue
         */
        public Animal dequeueAny() throws AnimalNotAvailableException
        {
                if (!animals.isEmpty()) {
                        Animal animal = animals.removeLast();
                        return animal;
                } else {
                        throw new AnimalNotAvailableException();
                }
        }


        /**
         * Returns the cat that has been at the shelter the longest.
         * @return Cat at end of queue
         */
        public Animal dequeueCat() throws CatNotAvailableException, AnimalNotAvailableException
        {
                // No animals are availavle if the shelter is empty.
                if (animals.isEmpty()) {
                        throw new AnimalNotAvailableException();
                }

                // look for the first cat (from tail->head) and remove it
                Cat c = new Cat();
                Iterator<Animal> i = animals.descendingIterator();
                while (i.hasNext()) {
                        Animal animal = i.next();
                        if (animal.getClass().equals(c.getClass())) {
                                animals.remove(animal);
                                return animal;
                        }
                }

                // If we don't find a cat, throw an exception
                throw new CatNotAvailableException();
        }

        /**
         * Returns the dog that has been at the shelter the longest.
         * @return Dog at end of queue
         */
        public Animal dequeueDog() throws DogNotAvailableException, AnimalNotAvailableException
        {
                // No animals are availavle if the shelter is empty.
                if (animals.isEmpty()) {
                        throw new AnimalNotAvailableException();
                }

                // look for the first dog (from tail->head) and remove it
                Dog d = new Dog();
                Iterator<Animal> i = animals.descendingIterator();
                while (!animals.isEmpty() && i.hasNext()) {
                        Animal animal = i.next();
                        if (animal.getClass().equals(d.getClass())) {
                                animals.remove(animal);
                                return animal;
                        }
                }

                // If we don't find a dog, throw an exception
                throw new DogNotAvailableException();
        }
}
