package com.example.historialmedicopersonal.navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.historialmedicopersonal.R;

import java.util.List;

public class HistorialAdapter extends RecyclerView.Adapter<HistorialAdapter.HistorialViewHolder> {

    private List<Historial> historialList;

    public HistorialAdapter(List<Historial> historialList) {
        this.historialList = historialList;
    }

    @NonNull
    @Override
    public HistorialViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_historial, parent, false);
        return new HistorialViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistorialViewHolder holder, int position) {
        Historial historial = historialList.get(position);
        holder.nombrePruebaTextView.setText(historial.getNombrePrueba());
        holder.fechaTextView.setText(historial.getFecha());
        holder.resultadoTextView.setText(historial.getResultado());
    }

    @Override
    public int getItemCount() {
        return historialList.size();
    }

    public void updateData(List<Historial> newHistorialList) {
        historialList.clear();
        historialList.addAll(newHistorialList);
        notifyDataSetChanged();
    }

    static class HistorialViewHolder extends RecyclerView.ViewHolder {
        TextView nombrePruebaTextView;
        TextView fechaTextView;
        TextView resultadoTextView;

        HistorialViewHolder(View itemView) {
            super(itemView);
            nombrePruebaTextView = itemView.findViewById(R.id.nombrePruebaTextView);
            fechaTextView = itemView.findViewById(R.id.fechaTextView);
            resultadoTextView = itemView.findViewById(R.id.resultadoTextView);
        }
    }
}
