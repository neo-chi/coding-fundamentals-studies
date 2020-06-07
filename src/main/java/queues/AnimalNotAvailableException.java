package queues;

public class AnimalNotAvailableException extends Exception
{
        /**
        *
        */
        private static final long serialVersionUID = 1L;

        public AnimalNotAvailableException()
        {
                // Nothing to do here...
        }

        @Override
        public String toString()
        {
                return "No animals are in this shelter!";
        }
}
