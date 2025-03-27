import java.io.File;
import java.nio.file.Files;
import java.util.List;
import com.google.cloud.speech.v1.*;

public class SpeechProcessor {
    public void transcribeAudio(String filePath) {
        try {
            SpeechClient speechClient = SpeechClient.create();
            byte[] audioBytes = Files.readAllBytes(new File(filePath).toPath());

            RecognitionConfig config = RecognitionConfig.newBuilder()
                    .setEncoding(RecognitionConfig.AudioEncoding.LINEAR16)
                    .setSampleRateHertz(16000)
                    .setLanguageCode("en-US")
                    .build();

            RecognitionAudio audio = RecognitionAudio.newBuilder()
                    .setContent(ByteString.copyFrom(audioBytes))
                    .build();

            RecognizeResponse response = speechClient.recognize(config, audio);
            List<SpeechRecognitionResult> results = response.getResultsList();

            StringBuilder transcript = new StringBuilder();
            for (SpeechRecognitionResult result : results) {
                transcript.append(result.getAlternatives(0).getTranscript()).append(" ");
            }

            speechClient.close();
            String noteText = transcript.toString().trim();
            System.out.println("\n📝 Transcribed Note: " + noteText);

            NoteStorage storage = new NoteStorage();
            storage.saveNote(noteText);

        } catch (Exception e) {
            System.out.println("❌ Error processing audio: " + e.getMessage());
        }
    }
}
