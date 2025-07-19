import java.util.HashMap;
import java.util.Map;

public class ResponseEngine {
    private Map<String, String> faq;

    public ResponseEngine() {
        faq = new HashMap<>();

        // Predefined questions and answers
        faq.put("hi", "Hello! How can I assist you?");
        faq.put("hello", "Hi there! Need any help?");
        faq.put("how are you", "I'm doing great! Thanks for asking.");
        faq.put("what is your name", "I'm JavaBot, your virtual assistant.");
        faq.put("bye", "Goodbye! Have a great day.");
        faq.put("help", "You can ask me about our services, timings, or general questions.");
    }

    public String getResponse(String input) {
        String lowerInput = input.toLowerCase().trim();

        for (String key : faq.keySet()) {
            if (lowerInput.contains(key)) {
                return faq.get(key);
            }
        }

        return "I'm sorry, I didn't understand that. Could you rephrase?";
    }
}
