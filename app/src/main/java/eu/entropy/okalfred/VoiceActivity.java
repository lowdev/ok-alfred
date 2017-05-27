package eu.entropy.okalfred;

import android.app.Activity;
import android.app.VoiceInteractor;
import android.content.Intent;
import android.os.Bundle;

public class VoiceActivity extends Activity {

    class Confirm extends VoiceInteractor.ConfirmationRequest {
        public Confirm(VoiceInteractor.Prompt prompt) {
            super(prompt, null);
        }

        @Override
        public void onConfirmationResult(boolean confirmed, android.os.Bundle result){
            if (confirmed) {
                //doAction();
            }
            //Intent intent = new Intent(this, VoiceActivity.class);
            //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            //startActivity(intent);
            finish();
        }
    };

    @Override
    public void onResume() {
        super.onResume();
        if (isVoiceInteraction()) {
            String ttsPrompt = "Hey !";
            String visualPrompt = "Hey !";
            getVoiceInteractor().submitRequest(new Confirm(createVoiceInteractor(ttsPrompt, visualPrompt)));
        } else {
            finish();
        }
    }

    private VoiceInteractor.Prompt createVoiceInteractor(String ttsPrompt, String visualPrompt) {
        return new VoiceInteractor.Prompt(new String[]{ttsPrompt}, visualPrompt);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
