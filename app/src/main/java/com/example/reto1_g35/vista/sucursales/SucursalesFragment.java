package com.example.reto1_g35.vista.sucursales;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.reto1_g35.BuildConfig;
import com.example.reto1_g35.R;


import org.osmdroid.config.Configuration;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.ItemizedOverlayWithFocus;
import org.osmdroid.views.overlay.OverlayItem;
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider;
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay;

import java.util.ArrayList;

public class SucursalesFragment extends Fragment {

    private View view;
    private MapView myOpenMapView;
    private MapController mapController;

    public SucursalesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_sucursales, container, false);
        //--------------------------------------------------------------------------------

        myOpenMapView = (MapView) view.findViewById(R.id.mapView);

        //-------- VALOR DE AGENTE DE USUARIO----------------

        Configuration.getInstance().setUserAgentValue(BuildConfig.APPLICATION_ID);

        /*--- Puntos de Geolocalización--------*/
        GeoPoint titanBogota = new GeoPoint(4.69484,-74.08620);
        GeoPoint teusaquillo = new GeoPoint(4.64822,-74.12003);
        GeoPoint metropolis = new GeoPoint(4.68097,-74.08248);
        GeoPoint unicentroOccidente = new GeoPoint(4.72391,-74.11491);


        /*-- Enlaces --*/

        myOpenMapView.setBuiltInZoomControls(true);

        mapController = (MapController) myOpenMapView.getController();
        mapController.setCenter(titanBogota);
        mapController.setZoom(13);

        myOpenMapView.setMultiTouchControls(true);

        /*-- Hilo de cargue dinámico de mapa --*/

        final MyLocationNewOverlay myLocationNewOverlay = new MyLocationNewOverlay(new GpsMyLocationProvider(getContext()),myOpenMapView);
        myOpenMapView.getOverlays().add(myLocationNewOverlay);
        myLocationNewOverlay.enableMyLocation();

        myLocationNewOverlay.runOnFirstFix(new Runnable() {
            @Override
            public void run() {
                mapController.animateTo(myLocationNewOverlay.getMyLocation());
            }
        });

        //--------------------------------------------------------------------------------

        /*--- Puntos sucursal ---*/

        ArrayList<OverlayItem> sucursales = new ArrayList<OverlayItem>();
        sucursales.add(new OverlayItem("JAcket Store Teusaquillo","Calle 19 # 69-79",teusaquillo));
        sucursales.add(new OverlayItem("JAcket Store CC Metrópolis", "Avenida 68 # 75A - 50", metropolis ));
        sucursales.add(new OverlayItem("JAcket Store Unicentro Occidente", "Carrera 111C #86 - 74", unicentroOccidente));

        ItemizedIconOverlay.OnItemGestureListener<OverlayItem> tap = new ItemizedIconOverlay.OnItemGestureListener<OverlayItem>() {
            @Override
            public boolean onItemSingleTapUp(int index, OverlayItem item) {
                return false;
            }

            @Override
            public boolean onItemLongPress(int index, OverlayItem item) {
                return false;
            }
        };

        ItemizedOverlayWithFocus<OverlayItem> capa = new ItemizedOverlayWithFocus<OverlayItem>(getContext(),sucursales,tap);
        capa.setFocusItemsOnTap(true);
        myOpenMapView.getOverlays().add(capa);

        return view;
    }
}