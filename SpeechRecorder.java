import javax.sound.sampled.*;
import java.io.*;

public class SpeechRecorder {
    private static final String AUDIO_FILE = "audio.wav";

    public void recordAudio() {
        try {
            AudioFormat format = new AudioFormat(16000, 16, 1, true, true);
            DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
            if (!AudioSystem.isLineSupported(info)) {
                System.out.println("❌ Audio recording not supported.");
                return;
            }

            TargetDataLine line = (TargetDataLine) AudioSystem.getLine(info);
            line.open(format);
            line.start();

            System.out.println("🎤 Recording... Press ENTER to stop.");
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            while (System.in.available() == 0) {
                int bytesRead = line.read(buffer, 0, buffer.length);
                out.write(buffer, 0, bytesRead);
            }

            line.stop();
            line.close();

            byte[] audioData = out.toByteArray();
            try (FileOutputStream fos = new FileOutputStream(AUDIO_FILE)) {
                fos.write(audioData);
            }

            System.out.println("✅ Recording saved. Processing transcription...");
            SpeechProcessor transcriber = new SpeechProcessor();
            transcriber.transcribeAudio(AUDIO_FILE);
        } catch (Exception e) {
            System.out.println("❌ Error recording audio: " + e.getMessage());
        }
    }
}
