package com.example.reto4.vista.sucursales;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.reto4.BuildConfig;
import com.example.reto4.R;


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
        GeoPoint santafe = new GeoPoint(4.76194444,-74.04638889);
        GeoPoint estancion = new GeoPoint( 4.64777778,-74.10138889);
        GeoPoint americas = new GeoPoint(4.6183927,-74.1358538);



        /*-- Enlaces --*/

        myOpenMapView.setBuiltInZoomControls(true);

        mapController = (MapController) myOpenMapView.getController();
        mapController.setCenter(santafe);
        mapController.setZoom(12);

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
        sucursales.add(new OverlayItem("Kelda en CC Santafé","Cra. 51 #  183-17",santafe));
        sucursales.add(new OverlayItem("Kelda en CC gran estanción", "Ac. 26 # 62-47", estancion ));
        sucursales.add(new OverlayItem("Kelda en plaza de las americas", "Cra 71D # 6-94 Sur", americas));

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

        //--------------------------------------------------------------------------------

        return view;
    }
}