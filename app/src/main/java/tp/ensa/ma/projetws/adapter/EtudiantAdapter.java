package tp.ensa.ma.projetws.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

import tp.ensa.ma.projetws.R;
import tp.ensa.ma.projetws.beans.Etudiant;

public class EtudiantAdapter extends RecyclerView.Adapter<EtudiantAdapter.EtudiantViewHolder> {

    private Context context;
    private List<Etudiant> etudiantList;
    private OnEtudiantListener onEtudiantListener;

    public EtudiantAdapter(Context context, List<Etudiant> etudiantList, OnEtudiantListener onEtudiantListener) {
        this.context = context;
        this.etudiantList = etudiantList;
        this.onEtudiantListener = onEtudiantListener;
    }

    @NonNull
    @Override
    public EtudiantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_etudiant, parent, false);
        return new EtudiantViewHolder(view, onEtudiantListener);
    }

    @Override
    public void onBindViewHolder(@NonNull EtudiantViewHolder holder, int position) {
        Etudiant etudiant = etudiantList.get(position);
        holder.nom.setText(etudiant.getNom());
        holder.prenom.setText(etudiant.getPrenom());
        holder.ville.setText(etudiant.getVille());
        holder.sexe.setText(etudiant.getSexe());
    }

    @Override
    public int getItemCount() {
        return etudiantList.size();
    }

    public static class EtudiantViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView nom, prenom, ville, sexe;
        OnEtudiantListener onEtudiantListener;

        public EtudiantViewHolder(@NonNull View itemView, OnEtudiantListener onEtudiantListener) {
            super(itemView);
            nom = itemView.findViewById(R.id.text_nom);
            prenom = itemView.findViewById(R.id.text_prenom);
            ville = itemView.findViewById(R.id.text_ville);
            sexe = itemView.findViewById(R.id.text_sexe);
            this.onEtudiantListener = onEtudiantListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onEtudiantListener.onEtudiantClick(getAdapterPosition());
        }
    }

    public interface OnEtudiantListener {
        void onEtudiantClick(int position);
    }
}
