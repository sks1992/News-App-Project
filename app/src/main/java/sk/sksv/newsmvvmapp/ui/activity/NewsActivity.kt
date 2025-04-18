package sk.sksv.newsmvvmapp.ui.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import sk.sksv.newsmvvmapp.R
import sk.sksv.newsmvvmapp.databinding.ActivityNewsBinding

class NewsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewsBinding // DataBinding reference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHost =
            supportFragmentManager.findFragmentById(R.id.nav_graph_view) as NavHostFragment

        val navController = navHost.navController
        binding.bottomMenu.setupWithNavController(navController)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}

/*
ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

* This code is handling window insets in an Android app, specifically dealing with system bars
* (status bar and navigation bar) to ensure proper padding is applied to your view so that content
*  isn't obscured by these system UI elements.

Here's a breakdown of the code:

1. `ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main))`:
   - This sets a window insets listener on the view with ID `main` in your layout.
   - `ViewCompat` is a compatibility class that provides consistent behavior across different Android versions.

2. The lambda function `{ v, insets -> ... }` is the listener that will be called when window insets are applied:
   - `v` is the view you attached the listener to (`R.id.main` in this case)
   - `insets` contains the inset information (how much the system UI overlaps your app)

3. `val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())`:
   - Gets the dimensions of the system bars (status bar at top and navigation bar at bottom)
   - Returns an `Insets` object with `left`, `top`, `right`, and `bottom` values

4. `v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)`:
   - Applies padding to the view equal to the system bar insets
   - This ensures your content isn't hidden behind the system UI

5. `insets`:
   - The listener returns the original `insets` object, allowing the insets to propagate further down the view hierarchy if needed

In simpler terms, this code makes sure your main view has proper padding so that its content isn't
* covered by the system status bar (at the top) or navigation bar (at the bottom). This is particularly
*  important for edge-to-edge designs where your app draws behind the system bars.

Note: In modern Android development (especially with Jetpack Compose becoming more prevalent),
* there are newer ways to handle window insets, but this approach remains valid for traditional view-based layouts.
* */