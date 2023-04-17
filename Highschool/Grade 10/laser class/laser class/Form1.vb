Public Class Form1
    Dim bullets(-1) As bullet
    Dim count As Integer
    Class bullet
        Inherits PictureBox
        Sub New()
            With Me
                .Size = New Size(10, 30)
                .Location = Form1.PictureBox1.Location
                .BackColor = Color.Black

            End With
        End Sub
        Sub shoot()
            Me.Top -= 3

        End Sub
    End Class
    Private Sub Form1_KeyDown(sender As Object, e As KeyEventArgs) Handles MyBase.KeyDown
        Select Case e.KeyCode
            Case Keys.Space
                ReDim Preserve bullets(count)
                Dim bullet1 As New bullet
                Controls.Add(bullet1)
                bullets(count) = bullet1
                count += 1
                tmrshoot.Enabled = True
                tmrshoot.Start()

        End Select
    End Sub

    Private Sub tmrshoot_Tick(sender As Object, e As EventArgs) Handles tmrshoot.Tick
        For x = 0 To bullets.Length - 1
            bullets(x).shoot()



        Next
    End Sub
End Class
