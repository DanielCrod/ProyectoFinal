package SQL

import Usuario.Usuario
import Usuario.UsuariosContract
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Build.VERSION

class SqliteHelper(context: Context)
    :SQLiteOpenHelper(context, NAME, null, VERSION){

        companion object {
            const val NAME = "usuarios.db"
            const val VERSION = 1
        }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE " + UsuariosContract.TABLE_NAME + " ( "
                        + UsuariosContract.EMAIL + " TEXT PRIMARY KEY, "
                        + UsuariosContract.NOMBRE + " TEXT NOT NULL, "
                        + UsuariosContract.APELLIDO + " TEXT NOT NULL);")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun insertar (usuario: Usuario) {
        val db = readableDatabase
        val values = ContentValues()
        values.put(UsuariosContract.EMAIL, usuario.email)
        values.put(UsuariosContract.NOMBRE, usuario.nombre)
        values.put(UsuariosContract.APELLIDO, usuario.apellido)

        db.insert(UsuariosContract.TABLE_NAME, null, values)
    }
}