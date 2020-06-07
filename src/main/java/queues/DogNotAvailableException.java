package queues;

public class DogNotAvailableException extends Exception
{
        /**
        *
        */
        private static final long serialVersionUID = 1L;

        public DogNotAvailableException()
        {
                // Nothing to do here...
        }

        @Override
        public String toString()
        {
                return "No dogs are in this shelter!";
        }
}
