package queues;

public class CatNotAvailableException extends Exception
{
        /**
        *
        */
        private static final long serialVersionUID = 1L;

        public CatNotAvailableException()
        {
                // Nothing to do here...
        }

        @Override
        public String toString()
        {
                return "No cats are in this shelter!";
        }
}
