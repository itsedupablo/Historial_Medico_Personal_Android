package com.example.historialmedicopersonal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.historialmedicopersonal.navigation.Medicacion;

import java.util.List;

public class MedicacionAdapter extends RecyclerView.Adapter<MedicacionAdapter.MedicacionViewHolder> {

    private List<Medicacion> medicacionList;

    public MedicacionAdapter(List<Medicacion> medicacionList) {
        this.medicacionList = medicacionList;
    }

    @NonNull
    @Override
    public MedicacionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_medicacion, parent, false);
        return new MedicacionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MedicacionViewHolder holder, int position) {
        Medicacion medicacion = medicacionList.get(position);
        holder.nombreMedicamentoTextView.setText(medicacion.getNombreMedicamento());
        holder.dosisTextView.setText(medicacion.getDosis());
        holder.frecuenciaTextView.setText(medicacion.getFrecuencia());
    }

    @Override
    public int getItemCount() {
        return medicacionList.size();
    }

    public void updateData(List<Medicacion> newMedicacionList) {
        medicacionList.clear();
        medicacionList.addAll(newMedicacionList);
        notifyDataSetChanged();
    }

    static class MedicacionViewHolder extends RecyclerView.ViewHolder {
        TextView nombreMedicamentoTextView;
        TextView dosisTextView;
        TextView frecuenciaTextView;

        MedicacionViewHolder(View itemView) {
            super(itemView);
            nombreMedicamentoTextView = itemView.findViewById(R.id.nombreMedicamentoTextView);
            dosisTextView = itemView.findViewById(R.id.dosisTextView);
            frecuenciaTextView = itemView.findViewById(R.id.frecuenciaTextView);
        }
    }
}
