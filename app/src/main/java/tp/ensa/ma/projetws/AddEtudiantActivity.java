package tp.ensa.ma.projetws;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore; // Pour accéder à la galerie
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView; // Pour afficher l'image
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import java.util.HashMap;
import java.util.Map;
import android.net.Uri; // Pour les URI d'images


public class AddEtudiantActivity extends AppCompatActivity {
    private EditText nom, prenom;
    private Spinner ville;
    private RadioGroup sexeGroup;
    private Button add;
    private RequestQueue requestQueue;

    String insertUrl ="http://192.168.1.151/PhpProject1/ws/createEtudiant.php"; // Remplace par ton URL


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_etudiant);

        // Initialiser les widgets
        nom = findViewById(R.id.nom);
        prenom = findViewById(R.id.prenom);
        ville = findViewById(R.id.ville);
        sexeGroup = findViewById(R.id.groupe_sexe);
        add = findViewById(R.id.btn_add);

        // Initialiser Volley
        requestQueue = Volley.newRequestQueue(this);

        // Ajouter un événement sur le bouton "Ajouter"
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ajouterEtudiant();
            }
        });
    }

    private void ajouterEtudiant() {
        if (nom.getText().toString().isEmpty() || prenom.getText().toString().isEmpty()) {
            Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
            return;
        }
        String insertUrl = "http://192.168.1.151:8080/PhpProject1/ws/createEtudiant.php";

        // Création de la requête POST
        StringRequest request = new StringRequest(Request.Method.POST, insertUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Handle successful response
                        Toast.makeText(AddEtudiantActivity.this, "Student added successfully!", Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // This is the block you asked about
                        if (error.networkResponse != null) {
                            String response = new String(error.networkResponse.data);
                            Log.e("Error", response);
                            Toast.makeText(AddEtudiantActivity.this, "Server Error: " + response, Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(AddEtudiantActivity.this, "Network error", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> params = new HashMap<>();
                params.put("nom", nom.getText().toString());
                params.put("prenom", prenom.getText().toString());
                params.put("ville", ville.getSelectedItem().toString());
                params.put("sexe", ((RadioButton) findViewById(sexeGroup.getCheckedRadioButtonId())).getText().toString());
                return params;
            }
        };

// Adding the request to the RequestQueue
        requestQueue.add(request);

    }}