Public Class Form1

    Dim ybvelocity As Integer = -3

    Private Sub Form1_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        tmrlaser.Start()


    End Sub
    Sub movelaser()
        Dim block As Integer
        block = lblaser.Top
        block = block + ybvelocity

        lblaser.Top = block


    End Sub

    Private Sub tmrlaser_Tick(sender As Object, e As EventArgs) Handles tmrlaser.Tick
        movelaser()
    End Sub
End Class
