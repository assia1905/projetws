package tp.ensa.ma.projetws;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

import tp.ensa.ma.projetws.adapter.EtudiantAdapter;
import tp.ensa.ma.projetws.beans.Etudiant;

public class ListeEtudiantsActivity extends AppCompatActivity implements EtudiantAdapter.OnEtudiantListener {

    private RecyclerView recyclerView;
    private EtudiantAdapter etudiantAdapter;
    private List<Etudiant> etudiantList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_etudiants);

        recyclerView = findViewById(R.id.recyclerView);
        etudiantList = new ArrayList<>(); // Remplis la liste avec les données des étudiants

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        etudiantAdapter = new EtudiantAdapter(this, etudiantList, this);
        recyclerView.setAdapter(etudiantAdapter);

        // Charger les étudiants ici (ex. depuis l'API REST ou une base de données locale)
        chargerEtudiants();
    }

    private void chargerEtudiants() {
        // Code pour récupérer les étudiants et les ajouter à la liste
        // Mettre à jour l'adaptateur une fois les données récupérées
        etudiantAdapter.notifyDataSetChanged();
    }

    @Override
    public void onEtudiantClick(int position) {
        Etudiant etudiant = etudiantList.get(position);
        Toast.makeText(this, "Étudiant sélectionné : " + etudiant.getNom(), Toast.LENGTH_SHORT).show();

        // Lancer une activité pour la modification de l'étudiant
        Intent intent = new Intent(ListeEtudiantsActivity.this, AddEtudiantActivity.class);
        intent.putExtra("etudiantId", etudiant.getId());
        startActivity(intent);
    }
}
