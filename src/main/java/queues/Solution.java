package queues;

import java.util.Scanner;

/*
 * Problem Statement: An animal shelter, which holds only dogs and cats,
 * operates on a strictly "first in, first out" basis. People must adopt either
 * the "oldest" (based on arrival time) of all animals at the shelter, or they
 * can select whether they would prefer a dog or a cat(and will receive the
 * oldest animal of that type). They cannot select which specific animal they
 * would like. Create the data structures to maintain this system and implement
 * operations suych as enqueue, dequeueAny, dequeueDog, and dequeueCat. You may
 * use the built-in LinkedList data structure.
 */

 /* Notes:
  * "first in, first out" -> queue adopt oldest (arrival time) of all ANIMALS
  * in shelter OR select dog OR cat -> receive oldest
  *
  * dequeueAny() -> returns oldest animal -> return animal at end of ANIMAL queue
  * dequeueDog() -> returns oldest dog    -> return dog at end of DOG queue
  * dequeueCat() -> returns oldest cat    -> return cat at end of CAT queue
  *
  * Strategy 1: Provide 1 queue holding any Animal (dog or cat).
  * -> dequeueAny() : return end of queue
  * -> dequeueDog() : search for last index of type Dog : return that Dog
  * -> dequeueCat() : search for last index of type Cat : return that Cat
  *
  * Strategy 2: Provide 1 queue for Dog, Provide 1 queue for Cat, Provide 1 Queue for Animal
  * -> Every cat and dog are entered into Animal queue in order
  * -> if Cat added, also add cat to Cat queue
  * -> if Dog added, also add dog to Dog queue
  * -> dequeueAny() : return end of Animal queue, remove animal of that type from the Dog or Cat queue
  * -> dequeueDog() : search for last index of type Dog : return that Dog : remove last occurence of Dog from Animal queue
  * -> dequeueCat() : search for last index of type Cat : return that Cat : remove last occurence of Cat from Animal queue
  */

/**
 *
 */
public class Solution
{
        public static void main(String[] args)
        {
                /** Add animals to shelter */
                Animal[] animalsToShelter = {new Cat(), new Dog(), new Dog(), new Dog(), new Cat(), new Dog()};
                AnimalShelter animalShelter = new AnimalShelter(animalsToShelter);

                boolean adoptAnother = true;
                Scanner input = new Scanner(System.in);;
                while (adoptAnother) {
                        System.out.println("What would you like to adopt? (A)ny/(C)at/(D)og");
                        try {
                                switch (input.next()) {
                                case "A":
                                case "a":
                                        Animal animal = animalShelter.dequeueAny();
                                        animal.sound();
                                        break;
                                case "C":
                                case "c":
                                        Animal cat = animalShelter.dequeueCat();
                                        cat.sound();
                                        break;
                                case "D":
                                case "d":
                                        Animal dog = animalShelter.dequeueDog();
                                        dog.sound();
                                        break;
                                default:
                                        System.out.println("invalid choice!");
                                        break;
                                }
                        } catch (AnimalNotAvailableException e) {
                                System.out.println(e);
                        } catch (CatNotAvailableException e) {
                                System.out.println(e);
                        } catch (DogNotAvailableException e) {
                                System.out.println(e);
                        } finally {
                                boolean receivedAnswer = false;
                                while (!receivedAnswer) {
                                        System.out.println("Would you like to adopt another? (Y)es/(N)o");
                                        switch (input.next()) {
                                        case "Y":
                                        case "y":
                                                adoptAnother = true;
                                                receivedAnswer = true;
                                                break;
                                        case "N":
                                        case "n":
                                                adoptAnother = false;
                                                receivedAnswer = true;
                                                break;
                                        default:
                                                receivedAnswer = false;
                                                break;

                                        }
                                }
                        }
                }
        input.close();
        }
}