package lt.arnas.employees

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    lateinit var employeeListView: ListView
    lateinit var adapter: CustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        employeeListView = findViewById(R.id.employeeListView)

        val employees = mutableListOf<Employee>()
        generateListOfEmployees(employees)

        adapter = CustomAdapter(this)
        adapter.add(employees)
        adapter.add(Employee(101, "text01", "text02", "text03"))
        adapter.add(
            Employee(102, "text01", "text02", "text03"),
            Employee(103, "text01", "text02", "text03"),
            Employee(104, "text01", "text02", "text03"),
            Employee(105, "text01", "text02", "text03"),
        )
        employeeListView.adapter = adapter

    }

    private fun generateListOfEmployees(employees: MutableList<Employee>) {
        for (item in 1..10) {
            employees.add(
                Employee(
                    item,
                    "Text01_%04x".format(item),
                    "Text02_%06x".format(item),
                    "Position_%06x".format(item),
                )
            )
        }
    }
}